package kr.toyauction.domain.file.dto;

import kr.toyauction.domain.file.entity.FileType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
public class FilePostRequest {

	@NotNull
	private FileType type;

	@NotNull
	private MultipartFile file;
}
