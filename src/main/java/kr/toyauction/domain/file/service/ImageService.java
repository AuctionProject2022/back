package kr.toyauction.domain.file.service;

import kr.toyauction.domain.file.dto.ImagePostRequest;
import kr.toyauction.domain.file.entity.Image;
import kr.toyauction.domain.file.event.ImageUploadEvent;
import kr.toyauction.domain.file.repository.ImageRepository;
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
public class ImageService {

	private final ImageRepository imageRepository;
	private final ApplicationEventPublisher applicationEventPublisher;

	@Transactional
	public Image save(@NotNull final ImagePostRequest imagePostRequest) {

		String prefixKey = CommonUtils.generateS3PrefixKey();
		String fileName = CommonUtils.generateRandomFilename(Objects.requireNonNull(imagePostRequest.getFile().getOriginalFilename()));
		Image image = Image.builder()
				.domain(imagePostRequest.getDomain())
				.memberId(0L) // TODO
				.path(prefixKey + fileName)
				.build();
		image.validation();
		applicationEventPublisher.publishEvent(new ImageUploadEvent(prefixKey + fileName, imagePostRequest.getFile()));
		return imageRepository.save(image);
	}
}
