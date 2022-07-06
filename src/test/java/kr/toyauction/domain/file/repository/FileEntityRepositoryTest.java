package kr.toyauction.domain.file.repository;

import kr.toyauction.domain.file.entity.FileEntity;
import kr.toyauction.domain.file.entity.FileType;
import kr.toyauction.global.configuration.TestJPAQueryFactoryConfiguration;
import kr.toyauction.global.util.CommonUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@EnableJpaAuditing
@Import(TestJPAQueryFactoryConfiguration.class)
class FileEntityRepositoryTest {

	@Autowired
	FileRepository fileRepository;
	List<FileEntity> initData;


	@BeforeEach
	void init() {
		List<FileEntity> fileEntities = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			fileEntities.add(FileEntity.builder()
					.memberId(0L)
					.type(FileType.PRODUCT_IMAGE)
					.path(CommonUtils.generateS3PrefixKey() + UUID.randomUUID() + ".png")
					.build());
		}
		initData = fileRepository.saveAll(fileEntities);
	}

	@Test
	@DisplayName("file entity 를 생성 합니다.")
	void save() {

		// given
		FileEntity fileEntity = FileEntity.builder()
				.memberId(0L)
				.type(FileType.PRODUCT_IMAGE)
				.path(CommonUtils.generateS3PrefixKey() + UUID.randomUUID() + ".png")
				.build();

		// when
		FileEntity saved = fileRepository.save(fileEntity);

		// then
		assertEquals(fileEntity.getPath(), saved.getPath());
		assertEquals(fileEntity.getMemberId(), saved.getMemberId());
		assertEquals(fileEntity.getType(), saved.getType());
		assertNotNull(saved.getId());
	}

	@Test
	@DisplayName("file entity 를 삭제 합니다.")
	void delete() {

		// given
		FileEntity firstData = initData.get(0);

		// when
		fileRepository.delete(firstData);

		// then
		Optional<FileEntity> findEntity = fileRepository.findById(firstData.getId());
		assertFalse(findEntity.isPresent());
	}

	@Test
	@DisplayName("file id 로 entity 를 조회 합니다.")
	void findById() {

		// given
		Long randomFileId = initData.get(new SecureRandom().nextInt(initData.size())).getId();

		// when
		Optional<FileEntity> findEntity = fileRepository.findById(randomFileId);

		// then
		assertTrue(findEntity.isPresent());
	}

}