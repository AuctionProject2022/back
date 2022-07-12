package kr.toyauction.domain.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoogleResponse {
    private String accessToken;
    private boolean refreshToken;

    public GoogleResponse(String accessToken, boolean refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
