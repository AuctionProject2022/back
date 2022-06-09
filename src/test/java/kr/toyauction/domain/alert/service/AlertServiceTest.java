package kr.toyauction.domain.alert.service;

import kr.toyauction.domain.alert.repository.AlertRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AlertServiceTest {

	@Mock
	AlertRepository alertRepository;

	AlertService alertService;
}