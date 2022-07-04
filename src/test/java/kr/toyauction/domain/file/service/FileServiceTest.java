package kr.toyauction.domain.file.service;

import kr.toyauction.domain.file.dto.FilePostRequest;
import kr.toyauction.domain.file.entity.FileEntity;
import kr.toyauction.domain.file.entity.FileType;
import kr.toyauction.global.property.TestFile;
import kr.toyauction.infra.aws.client.IntraAwsS3Client;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class FileServiceTest {

	@MockBean
	IntraAwsS3Client intraAwsS3Client;

	@Autowired
	FileService fileService;

	@Autowired
	ResourceLoader resourceLoader;

	@Test
	@DisplayName("파일을 생성 합니다.")
	void save() throws IOException {

		// given
		FileType fileType = FileType.PRODUCT_IMAGE;
		MultipartFile testFile = new MockMultipartFile(
				TestFile.PNG_FILENAME,
				resourceLoader.getResource(TestFile.PNG_CLASSPATH).getInputStream());

		FilePostRequest filePostRequest = FilePostRequest.builder()
				.type(fileType)
				.file(testFile)
				.build();

		// when
		FileEntity saved = fileService.save(filePostRequest);

		// then
		assertEquals(filePostRequest.getType(), saved.getType());
		assertNotNull(saved.getPath());
	}
}