package kr.toyauction.global.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.toyauction.global.dto.ErrorResponse;
import kr.toyauction.global.error.GlobalErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
	private final MessageSource messageSource;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
		log.error("UnAuthorizaed!!! message : " + authException.getMessage());
		String exception = (String)request.getAttribute(JwtCode.EXCEPTION_PRODUCE.getDescription());

		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		GlobalErrorCode errorCode = GlobalErrorCode.G0007;
		ErrorResponse errorResponse = new ErrorResponse(errorCode.name(),messageSource.getMessage(errorCode.name(), null, LocaleContextHolder.getLocale()));

		if (exception.equals(JwtCode.ERROR_EXPIRED_TOKEN.getDescription())){
			errorCode = GlobalErrorCode.G0008;
			errorResponse.setCode(errorCode.name());
			errorResponse.setMessage(messageSource.getMessage(errorCode.name(), null, LocaleContextHolder.getLocale()));
		}

		try (OutputStream os = response.getOutputStream()) {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.writeValue(os, errorResponse);
			os.flush();
		}
	}
}