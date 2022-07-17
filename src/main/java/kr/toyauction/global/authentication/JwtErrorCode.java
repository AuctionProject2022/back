package kr.toyauction.global.authentication;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public enum JwtErrorCode {
//    UNKNOWN_ERROR(""),
//    WRONG_TYPE_TOKEN(""),
    EXPIRED_TOKEN("expiredJwt");
//    UNSUPPORTED_TOKEN("");

    private final String description;

    JwtErrorCode(String description) {
        this.description = description;
    }
}
