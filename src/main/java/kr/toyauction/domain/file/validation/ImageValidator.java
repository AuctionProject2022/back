package kr.toyauction.domain.file.validation;

import kr.toyauction.domain.file.dto.ImagePostRequest;
import kr.toyauction.domain.file.error.FileErrorCode;
import kr.toyauction.global.error.GlobalErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Slf4j
@Component
@RequiredArgsConstructor
public class ImageValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ImagePostRequest.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		if (target instanceof ImagePostRequest) {

			ImagePostRequest request = (ImagePostRequest) target;
			if (request.getFile() != null) {

				if(!enableContentTypes(request.getFile().getContentType())){
					errors.rejectValue("file", FileErrorCode.F0001.name(), new String[]{"jpg, gif, png"}, null);
				}


			}

		}
	}


	private boolean enableContentTypes(final String contentType) {
		String[] enableContentTypes = {
				"image/jpeg",
				"image/gif",
				"image/png"
		};
		for (String enableContentType : enableContentTypes) {
			if (enableContentType.equals(contentType)) {
				return true;
			}
		}
		return false;
	}
}
