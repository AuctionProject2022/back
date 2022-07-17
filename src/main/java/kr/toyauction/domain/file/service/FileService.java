package kr.toyauction.domain.file.service;

import kr.toyauction.domain.file.dto.FilePostRequest;
import kr.toyauction.domain.file.entity.FileEntity;
import kr.toyauction.domain.file.repository.FileRepository;
import kr.toyauction.global.util.CommonUtils;
import kr.toyauction.infra.aws.client.IntraAwsS3Client;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileService {

	private final FileRepository fileRepository;
	private final IntraAwsS3Client intraAwsS3Client;

	@Transactional
	public FileEntity save(final FilePostRequest request) {

		String prefixKey = CommonUtils.generateS3PrefixKey();
		String randomFilename = CommonUtils.generateRandomFilename(Objects.requireNonNull(request.getFile().getOriginalFilename()));

		FileEntity fileEntity = FileEntity.builder()
				.memberId(0L) // TODO
				.path(prefixKey + randomFilename)
				.build();
		fileEntity.validation();
		intraAwsS3Client.upload(request.getFile(), prefixKey + randomFilename);
		return fileRepository.save(fileEntity);
	}
}
