package kr.toyauction.domain.file.service;

import kr.toyauction.domain.file.dto.FilePostRequest;
import kr.toyauction.domain.file.entity.FileEntity;
import kr.toyauction.domain.file.repository.FileRepository;
import kr.toyauction.global.property.TestProperty;
import kr.toyauction.global.util.CommonUtils;
import kr.toyauction.infra.aws.client.IntraAwsS3Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.context.support.GenericWebApplicationContext;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith({MockitoExtension.class})
class FileServiceTest {

	@Mock
	FileRepository fileRepository;

	@Mock
	IntraAwsS3Client intraAwsS3Client;

	FileService fileService;

	ResourceLoader resourceLoader;

	@BeforeEach
	void setMemberService() {
		fileService = new FileService(fileRepository, intraAwsS3Client);
		resourceLoader = new GenericWebApplicationContext();
	}

	@Test
	@DisplayName("success : 파일 생성")
	void save() throws IOException {

		// given
		MockMultipartFile file = new MockMultipartFile(
				"file",
				TestProperty.PNG_FILENAME,
				MediaType.IMAGE_PNG_VALUE,
				resourceLoader.getResource(TestProperty.PNG_CLASSPATH).getInputStream());
		FilePostRequest request = FilePostRequest.builder()
				.file(file)
				.build();
		given(fileRepository.save(any(FileEntity.class))).willReturn(FileEntity.builder()
				.id(1L)
				.memberId(0L)
				.path(CommonUtils.generateS3PrefixKey() + file.getOriginalFilename())
				.build());

		// when
		FileEntity saved = fileService.save(request);

		// then
		assertNotNull(saved.getId());
		assertNotNull(saved.getMemberId());
		assertNull(saved.getType());
		assertNull(saved.getTargetId());
		assertNotNull(saved.getPath());
	}

	@Test
	@DisplayName("fail : file 이 null 인 경우")
	void saveFileIsNull() {

		// given
		MockMultipartFile file = null;
		FilePostRequest request = FilePostRequest.builder()
				.file(file)
				.build();

		// when
		assertThrows(NullPointerException.class, () -> {
			fileService.save(request);
		});

		// then
	}
}