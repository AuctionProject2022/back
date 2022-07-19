package kr.toyauction.global.authentication;

import lombok.Getter;

@Getter
public enum JwtCode {
    ERROR_EXPIRED_TOKEN("expiredJwt"),
    EXCEPTION_PRODUCE("exception"),
    AUTHORITY("authority");

    private final String description;

    JwtCode(String description) {
        this.description = description;
    }
}
