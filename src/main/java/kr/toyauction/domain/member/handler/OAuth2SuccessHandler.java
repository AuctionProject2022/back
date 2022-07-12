package kr.toyauction.domain.member.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.toyauction.domain.member.dto.GoogleResponse;
import kr.toyauction.domain.member.dto.Token;
import kr.toyauction.domain.member.entity.Member;
import kr.toyauction.domain.member.enums.Role;
import kr.toyauction.domain.member.repository.MemberRepository;
import kr.toyauction.global.authentication.JwtProvider;
import kr.toyauction.global.dto.SuccessResponse;
import kr.toyauction.global.dto.SuccessResponseHelper;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

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
        Optional<Member> oneByEmail = memberRepository.findByUserId((String) oAuth2User.getAttributes().get("email"));
        if (oneByEmail.isEmpty()) {
            Member createMember = Member.builder()
                    .userId((String) oAuth2User.getAttributes().get("email"))
                    .picture((String) oAuth2User.getAttributes().get("picture"))
                    .role(Role.USER)
                    .build();
            memberRepository.createMember(createMember);
            System.out.println("***********************************************");
        }else {
            System.out.println(oneByEmail.get().getId());
            Token token = jwtProvider.createToken(oneByEmail.get().getId());
            ResponseCookie cookie = ResponseCookie.from("refreshToken", token.getRefreshToken())
                    .maxAge(7 * 24 * 60 * 60)
                    .path("/")
                    .secure(true)
                    .sameSite("None")
                    .httpOnly(true)
                    .build();
            response.setHeader("Set-Cookie",cookie.toString());
            response.addHeader("access", token.getAccessToken());
            response.addHeader("Refresh", token.getRefreshToken());
            response.setContentType("application/json;charset=UTF-8");
            GoogleResponse googleResponse = new GoogleResponse(token.getAccessToken(),true);
            SuccessResponse<GoogleResponse> successResponse = new SuccessResponse<>(googleResponse);
            String result = mapper.writeValueAsString(successResponse);
            response.getWriter().write(result);
        }
        System.out.println("------------------------------------------------");
        System.out.println(oAuth2User);
        System.out.println(oAuth2User.getAttributes().get("email"));
        System.out.println(oneByEmail);
        System.out.println(oAuth2User.getAuthorities());
        System.out.println("------------------------------------------------");
    }
}
