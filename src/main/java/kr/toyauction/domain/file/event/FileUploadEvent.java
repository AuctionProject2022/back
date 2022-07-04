package kr.toyauction.domain.file.event;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FileUploadEvent {

	@NotNull
	private String key;

	@NotNull
	private MultipartFile file;
}
