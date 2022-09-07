package com.jpaa.mastercard.mc.web.logging;

import java.lang.reflect.Type;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import com.jpaa.mastercard.mc.web.controller.ControllerConfiguration;

@ControllerAdvice(basePackageClasses = ControllerConfiguration.class)
public class McRequestBodyInterceptor extends RequestBodyAdviceAdapter {

	private LoggingService loggingService;

	private HttpServletRequest request;

	public McRequestBodyInterceptor(LoggingService loggingService, HttpServletRequest request) {
		this.loggingService = loggingService;
		this.request = request;
	}

	@Override
	public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) {
		loggingService.displayReq(request, body);
		return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
	}

	@Override
	public boolean supports(MethodParameter methodParameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}
}
