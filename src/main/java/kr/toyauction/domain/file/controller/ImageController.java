package kr.toyauction.domain.file.controller;

import kr.toyauction.domain.file.dto.ImagePostRequest;
import kr.toyauction.domain.file.dto.ImagePostResponse;
import kr.toyauction.domain.file.entity.Image;
import kr.toyauction.domain.file.property.FilePath;
import kr.toyauction.domain.file.service.ImageService;
import kr.toyauction.global.dto.SuccessResponse;
import kr.toyauction.global.dto.SuccessResponseHelper;
import kr.toyauction.intra.property.IntraProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ImageController {

	private final ImageService imageService;
	private final IntraProperty intraProperty;

	@PostMapping(FilePath.IMAGES)
	public SuccessResponse<ImagePostResponse> postImage(@Validated final ImagePostRequest imagePostRequest) {
		Image image = imageService.save(imagePostRequest);
		return SuccessResponseHelper.success(new ImagePostResponse(image, intraProperty.getAwsS3Host()));
	}
}
