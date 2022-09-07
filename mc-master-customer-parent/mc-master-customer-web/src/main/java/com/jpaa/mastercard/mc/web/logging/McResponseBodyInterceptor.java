package com.jpaa.mastercard.mc.web.logging;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.jpaa.mastercard.mc.web.controller.ControllerConfiguration;

@ControllerAdvice(basePackageClasses = ControllerConfiguration.class)
public class McResponseBodyInterceptor implements ResponseBodyAdvice<Object> {

	private LoggingService loggingService;

	public McResponseBodyInterceptor(LoggingService loggingService) {
		this.loggingService = loggingService;
	}

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		loggingService.displayResp(((ServletServerHttpRequest) request).getServletRequest(),
				((ServletServerHttpResponse) response).getServletResponse(), body);
		return body;
	}
}
