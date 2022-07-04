package kr.toyauction.domain.file.dto;

import kr.toyauction.domain.file.entity.File;
import kr.toyauction.domain.file.entity.FileType;
import kr.toyauction.global.dto.BaseResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilePostResponse extends BaseResponse {

	private Long id;
	private Long memberId;
	private FileType domain;
	private Long domainId;
	private String path;

	public FilePostResponse(final File file, final String imageHost) {
		this.id = file.getId();
		this.memberId = file.getMemberId();
		this.domain = file.getDomain();
		this.domainId = file.getDomainId();
		this.path = imageHost + file.getPath();
		this.createDatetime = file.getCreateDatetime();
		this.updateDatetime = file.getUpdateDatetime();
	}
}
