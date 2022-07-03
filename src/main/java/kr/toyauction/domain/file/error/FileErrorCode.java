package kr.toyauction.domain.file.error;

import kr.toyauction.global.error.ErrorCode;
import org.springframework.http.HttpStatus;

public enum FileErrorCode implements ErrorCode {

	F0000(HttpStatus.INTERNAL_SERVER_ERROR);

	private final HttpStatus status;

	FileErrorCode(HttpStatus status) {
		this.status = status;
	}

	@Override
	public HttpStatus status() {
		return status;
	}
}
