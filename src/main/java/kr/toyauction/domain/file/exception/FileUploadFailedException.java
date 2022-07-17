package kr.toyauction.domain.file.exception;

import kr.toyauction.domain.file.error.FileErrorCode;
import kr.toyauction.global.exception.BusinessException;

public class FileUploadFailedException extends BusinessException {

	public FileUploadFailedException() {
		super(FileErrorCode.F0000);
	}
}
