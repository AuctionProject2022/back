package kr.toyauction.domain.member.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.toyauction.domain.member.dto.GoogleResponse;
import kr.toyauction.domain.member.dto.Token;
import kr.toyauction.domain.member.entity.Member;
import kr.toyauction.domain.member.enums.AuthProvider;
import kr.toyauction.domain.member.enums.Role;
import kr.toyauction.domain.member.repository.MemberRepository;
import kr.toyauction.global.authentication.JwtProvider;
import kr.toyauction.global.dto.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@Component
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final MemberRepository memberRepository;

    private final JwtProvider jwtProvider;
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    @Transactional
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        OAuth2User oAuth2User = (OAuth2User)authentication.getPrincipal();
        Member member = memberRepository.findByUserId((String) oAuth2User.getAttributes().get("email")); // 메일로 db 검색
        if (member == null) {
            String username = RandomStringUtils.randomAlphanumeric(10); // 랜덤 닉네임 생성
            member= memberRepository.findByUsername(username); // 닉네임으로 db 검색

            while (member != null) { // 닉네임으로 검색된 값이 있으면 랜덤 닉네임 다시 생성해서 검색 없을때 까지
                username = RandomStringUtils.randomAlphanumeric(10);
                member = memberRepository.findByUsername(username);
            }

            Member createMember = Member.builder()  // 멤버 정보 삽입
                    .userId((String) oAuth2User.getAttributes().get("email"))
                    .username(username)
                    .picture((String) oAuth2User.getAttributes().get("picture"))
                    .platform(AuthProvider.google)
                    .role(Role.USER)
                    .build();
            memberRepository.createMember(createMember);    // 멤버 등록
            member = memberRepository.findByUserId((String) oAuth2User.getAttributes().get("email"));
        }

        Token token = jwtProvider.createToken(member.getId(),authentication); // 토큰 발행
        member.setRefreshToken(token.getRefreshToken());      // 리프레쉬 토큰값 db에 업데이트
        ResponseCookie cookie = ResponseCookie.from("refreshToken", token.getRefreshToken()) // 헤더에 전달할 쿠키 설정
                .maxAge(7 * 24 * 60 * 60)
                .path("/")
                .secure(true)
                .sameSite("None")
                .httpOnly(true)
                .build();
        response.setHeader("Set-Cookie",cookie.toString());
        response.setContentType("application/json;charset=UTF-8");
        GoogleResponse googleResponse = new GoogleResponse(token.getAccessToken(),true); // 바디 응답 data
        SuccessResponse<GoogleResponse> successResponse = new SuccessResponse<>(googleResponse);
        String result = mapper.writeValueAsString(successResponse);
        response.getWriter().write(result);
    }
}
