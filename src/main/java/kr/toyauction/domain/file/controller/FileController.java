package kr.toyauction.domain.file.controller;

import kr.toyauction.domain.file.dto.FilePostRequest;
import kr.toyauction.domain.file.dto.FilePostResponse;
import kr.toyauction.domain.file.entity.FileEntity;
import kr.toyauction.domain.file.service.FileService;
import kr.toyauction.domain.file.validation.FileValidator;
import kr.toyauction.global.dto.SuccessResponse;
import kr.toyauction.global.dto.SuccessResponseHelper;
import kr.toyauction.global.property.GlobalProperty;
import kr.toyauction.global.property.Url;
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
	private final GlobalProperty globalProperty;

	@InitBinder
	protected void initBinders(WebDataBinder binder) {
		binder.addValidators(fileValidator);
	}

	@PostMapping(value = Url.FILE)
	public SuccessResponse<FilePostResponse> postFile(@Validated FilePostRequest request) {
		FileEntity fileEntity = fileService.save(request);
		return SuccessResponseHelper.success(new FilePostResponse(fileEntity, globalProperty.getAwsS3Host()));
	}
}
