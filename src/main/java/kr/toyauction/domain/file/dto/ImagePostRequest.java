package kr.toyauction.domain.file.dto;

import kr.toyauction.domain.file.entity.ImageDomain;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
public class ImagePostRequest {

	@NotNull
	private ImageDomain domain;

	@NotNull
	private MultipartFile file;
}
