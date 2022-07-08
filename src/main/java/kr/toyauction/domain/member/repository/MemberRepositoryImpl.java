package kr.toyauction.domain.member.repository;

import kr.toyauction.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{

    private final EntityManager em;

    public void createMember(Member member){
        em.persist(member);
        em.flush();
        em.clear();
    }
}
