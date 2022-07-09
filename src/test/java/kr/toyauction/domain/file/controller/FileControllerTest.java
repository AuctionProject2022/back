package kr.toyauction.domain.file.controller;

import kr.toyauction.domain.file.dto.FilePostRequest;
import kr.toyauction.domain.file.entity.FileEntity;
import kr.toyauction.domain.file.property.FilePath;
import kr.toyauction.domain.file.service.FileService;
import kr.toyauction.global.error.GlobalErrorCode;
import kr.toyauction.global.property.TestProperty;
import kr.toyauction.global.util.CommonUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.multipart;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.relaxedResponseFields;
import static org.springframework.restdocs.request.RequestDocumentation.partWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParts;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ExtendWith({RestDocumentationExtension.class})
class FileControllerTest {

	MockMvc mockMvc;

	@Autowired
	ResourceLoader resourceLoader;

	@MockBean
	FileService fileService;

	@BeforeEach
	public void setUp(WebApplicationContext webApplicationContext, RestDocumentationContextProvider restDocumentation) {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.apply(
						documentationConfiguration(restDocumentation)
								.uris()
								.withScheme(TestProperty.SPRING_REST_DOCS_SERVER_SCHEME)
								.withHost(TestProperty.SPRING_REST_DOCS_SERVER_HOST)
								.withPort(TestProperty.SPRING_REST_DOCS_SERVER_PORT)
								.and()
								.operationPreprocessors()
								.withRequestDefaults(prettyPrint())
								.withResponseDefaults(prettyPrint()))
				.build();
	}

	@Test
	@DisplayName("success : file 생성 ")
	void postFile() throws Exception {

		// given
		MockMultipartFile file = new MockMultipartFile(
				"file",
				TestProperty.PNG_FILENAME,
				MediaType.IMAGE_PNG_VALUE,
				resourceLoader.getResource(TestProperty.PNG_CLASSPATH).getInputStream());
		given(fileService.save(any(FilePostRequest.class))).willReturn(FileEntity.builder()
				.id(1L)
				.memberId(0L)
				.path(CommonUtils.generateS3PrefixKey() + CommonUtils.generateRandomFilename(file.getOriginalFilename()))
				.build());

		// when
		ResultActions resultActions = mockMvc.perform(multipart(FilePath.FILE)
						.file(file))
				.andDo(print())
				.andDo(document("post-file",
						requestParts(partWithName("file").description("file parameter name")),
						relaxedResponseFields(
								fieldWithPath("data.fileId").description("파일 고유번호"),
								fieldWithPath("data.memberId").description("회원 고유번호"),
								fieldWithPath("data.fileType").description("파일 타입"),
								fieldWithPath("data.targetId").description("타겟 도메인 ID"),
								fieldWithPath("data.path").description("파일 URL")
						)
				));

		// then
		resultActions.andExpect(status().isOk());
		resultActions.andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE));
		resultActions.andExpect(jsonPath("data.fileId").isNotEmpty());
		resultActions.andExpect(jsonPath("data.memberId").isNotEmpty());
		resultActions.andExpect(jsonPath("data.fileType").isEmpty());
		resultActions.andExpect(jsonPath("data.targetId").isEmpty());
		resultActions.andExpect(jsonPath("data.path").isNotEmpty());
	}

	@Test
	@DisplayName("fail : file 이 누락된 경우 ")
	void postFileIsFileNull() throws Exception {

		// given

		// when
		ResultActions resultActions = mockMvc.perform(post(FilePath.FILE))
				.andDo(print());

		// then
		resultActions.andExpect(status().isBadRequest());
		resultActions.andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE));
		resultActions.andExpect(jsonPath("success").value(Boolean.FALSE));
		resultActions.andExpect(jsonPath("code").value(GlobalErrorCode.G0001.name()));
	}

	@Test
	@DisplayName("fail : 허용되지 않은 file 을 올린 경우 ")
	void postFileIsNotAllowed() throws Exception {

		// given
		MockMultipartFile file = new MockMultipartFile(
				"file",
				TestProperty.TXT_FILENAME,
				MediaType.TEXT_PLAIN_VALUE,
				resourceLoader.getResource(TestProperty.TXT_CLASSPATH).getInputStream());

		// when
		ResultActions resultActions = mockMvc.perform(multipart(FilePath.FILE)
						.file(file))
				.andDo(print());

		// then
		resultActions.andExpect(status().isBadRequest());
		resultActions.andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE));
		resultActions.andExpect(jsonPath("success").value(Boolean.FALSE));
		resultActions.andExpect(jsonPath("code").value(GlobalErrorCode.G0001.name()));
	}
}