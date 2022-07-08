package kr.toyauction.domain.member.repository;

import kr.toyauction.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberQueryRepository , MemberRepositoryCustom {

    Optional<Member> findByUserId(String userId);

    void createMember(Member member);
}
