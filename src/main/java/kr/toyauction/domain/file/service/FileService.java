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

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileService {

	private final FileRepository fileRepository;
	private final IntraAwsS3Client intraAwsS3Client;

	@Transactional
	public FileEntity save(@NotNull final FilePostRequest filePostRequest) {

		String prefixKey = CommonUtils.generateS3PrefixKey();
		String fileName = CommonUtils.generateRandomFilename(Objects.requireNonNull(filePostRequest.getFile().getOriginalFilename()));
		FileEntity fileEntity = FileEntity.builder()
				.type(filePostRequest.getType())
				.memberId(0L) // TODO
				.path(prefixKey + fileName)
				.build();
		fileEntity.validation();
		intraAwsS3Client.upload(filePostRequest.getFile(), prefixKey + fileName);
		return fileRepository.save(fileEntity);
	}
}
