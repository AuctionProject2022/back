package kr.toyauction.domain.member.service;

import kr.toyauction.domain.member.repository.MemberRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

	@Mock
	MemberRepository memberRepository;

	@Mock
	ApplicationEventPublisher applicationEventPublisher;

	MemberService memberService;

}