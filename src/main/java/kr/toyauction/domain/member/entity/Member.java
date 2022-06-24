package kr.toyauction.domain.member.entity;

import kr.toyauction.domain.member.enums.Role;
import kr.toyauction.global.entity.BaseEntity;
import kr.toyauction.global.entity.EntitySupport;
import kr.toyauction.global.exception.DomainValidationException;
import kr.toyauction.global.property.Regex;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Member extends BaseEntity implements EntitySupport {

    @Id
    @Column(name = "memberId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    @Column(unique = true)
    private String username;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Override
    public void validation() {
        if (username == null || !username.matches(Regex.USERNAME)) {
            log.error("nickname : {}", username);
            throw new DomainValidationException();
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
