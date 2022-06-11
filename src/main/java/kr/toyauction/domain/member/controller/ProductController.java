package kr.toyauction.domain.member.controller;

import kr.toyauction.domain.member.dto.MemberGetRequest;
import kr.toyauction.domain.member.dto.MemberGetResponse;
import kr.toyauction.domain.member.entity.Member;
import kr.toyauction.domain.member.property.MemberPath;
import kr.toyauction.global.dto.SuccessResponse;
import kr.toyauction.global.dto.SuccessResponseHelper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;

public class ProductController {

	@GetMapping("/2148124581258")
	public SuccessResponse<Page<MemberGetResponse>> getMembers(final Pageable pageable, final MemberGetRequest memberGetRequest) {
		return null;
	}
}
