package kr.toyauction.domain.file.dto;

import kr.toyauction.domain.file.entity.FileEntity;
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

	public FilePostResponse(final FileEntity fileEntity, final String imageHost) {
		this.id = fileEntity.getId();
		this.memberId = fileEntity.getMemberId();
		this.domain = fileEntity.getType();
		this.domainId = fileEntity.getTargetId();
		this.path = imageHost + fileEntity.getPath();
		this.createDatetime = fileEntity.getCreateDatetime();
		this.updateDatetime = fileEntity.getUpdateDatetime();
	}
}
