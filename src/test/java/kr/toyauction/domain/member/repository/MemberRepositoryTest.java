package kr.toyauction.domain.member.repository;

import kr.toyauction.global.configuration.TestJPAQueryFactoryConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@DataJpaTest
@EnableJpaAuditing
@Import(TestJPAQueryFactoryConfiguration.class)
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;
}