package kr.toyauction.domain.alert.repository;

import kr.toyauction.domain.alert.entity.Alert;
import kr.toyauction.global.configuration.TestJPAQueryFactoryConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@EnableJpaAuditing
@Import(TestJPAQueryFactoryConfiguration.class)
class AlertRepositoryTest {

	@Autowired
	AlertRepository alertRepository;

}