package kr.toyauction.domain.file.controller;

import kr.toyauction.domain.file.dto.FilePostRequest;
import kr.toyauction.domain.file.dto.FilePostResponse;
import kr.toyauction.domain.file.entity.File;
import kr.toyauction.domain.file.property.FilePath;
import kr.toyauction.domain.file.service.FileService;
import kr.toyauction.domain.file.validation.FileValidator;
import kr.toyauction.global.dto.SuccessResponse;
import kr.toyauction.global.dto.SuccessResponseHelper;
import kr.toyauction.intra.property.IntraProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class FileController {

	private final FileService fileService;
	private final FileValidator fileValidator;
	private final IntraProperty intraProperty;

	@InitBinder
	protected void initBinders(WebDataBinder binder) {
		binder.addValidators(fileValidator);
	}

	@PostMapping(FilePath.IMAGES)
	public SuccessResponse<FilePostResponse> postImage(@Validated final FilePostRequest filePostRequest) {
		File file = fileService.save(filePostRequest);
		return SuccessResponseHelper.success(new FilePostResponse(file, intraProperty.getAwsS3Host()));
	}
}
