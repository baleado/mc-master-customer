package com.jpaa.mastercard.mc.web.logging;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class McRequestInterceptor implements HandlerInterceptor {

	private LoggingService loggingService;

	public McRequestInterceptor(LoggingService loggingService) {
		this.loggingService = loggingService;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (request.getMethod().equals(HttpMethod.GET.name()) || request.getMethod().equals(HttpMethod.DELETE.name())
				|| request.getMethod().equals(HttpMethod.PUT.name())) {
			loggingService.displayReq(request, null);
		}
		return true;
	}

}
