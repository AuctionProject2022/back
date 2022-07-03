package kr.toyauction.domain.file.dto;

import kr.toyauction.domain.file.entity.Image;
import kr.toyauction.domain.file.entity.ImageDomain;
import kr.toyauction.global.dto.BaseResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImagePostResponse extends BaseResponse {

	private Long id;
	private Long memberId;
	private ImageDomain domain;
	private Long domainId;
	private String path;

	public ImagePostResponse(final Image image, final String imageHost) {
		this.id = image.getId();
		this.memberId = image.getMemberId();
		this.domain = image.getDomain();
		this.domainId = image.getDomainId();
		this.path = imageHost + image.getPath();
		this.createDatetime = image.getCreateDatetime();
		this.updateDatetime = image.getUpdateDatetime();
	}
}
