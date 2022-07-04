package kr.toyauction.domain.file.service;

import kr.toyauction.domain.file.dto.FilePostRequest;
import kr.toyauction.domain.file.entity.File;
import kr.toyauction.domain.file.event.FileUploadEvent;
import kr.toyauction.domain.file.repository.FileRepository;
import kr.toyauction.global.util.CommonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileService {

	private final FileRepository fileRepository;
	private final ApplicationEventPublisher applicationEventPublisher;

	@Transactional
	public File save(@NotNull final FilePostRequest filePostRequest) {

		String prefixKey = CommonUtils.generateS3PrefixKey();
		String fileName = CommonUtils.generateRandomFilename(Objects.requireNonNull(filePostRequest.getFile().getOriginalFilename()));
		File file = File.builder()
				.domain(filePostRequest.getDomain())
				.memberId(0L) // TODO
				.path(prefixKey + fileName)
				.build();
		file.validation();
		applicationEventPublisher.publishEvent(new FileUploadEvent(prefixKey + fileName, filePostRequest.getFile()));
		return fileRepository.save(file);
	}
}
