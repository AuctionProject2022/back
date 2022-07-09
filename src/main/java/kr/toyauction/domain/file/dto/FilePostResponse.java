package kr.toyauction.domain.file.dto;

import kr.toyauction.domain.file.entity.FileEntity;
import kr.toyauction.domain.file.entity.FileType;
import kr.toyauction.global.dto.BaseResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilePostResponse extends BaseResponse {

	private Long fileId;
	private Long memberId;
	private FileType fileType;
	private Long targetId;
	private String path;

	public FilePostResponse(final FileEntity fileEntity, final String imageHost) {
		this.fileId = fileEntity.getId();
		this.memberId = fileEntity.getMemberId();
		this.fileType = fileEntity.getType();
		this.targetId = fileEntity.getTargetId();
		this.path = imageHost + fileEntity.getPath();
		this.createDatetime = fileEntity.getCreateDatetime();
		this.updateDatetime = fileEntity.getUpdateDatetime();
	}
}
