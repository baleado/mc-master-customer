package com.jpaa.mastercard.mc.web.logging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoggingConfiguration implements WebMvcConfigurer {

	@Autowired
	private McRequestInterceptor mcRequestInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(mcRequestInterceptor).addPathPatterns("/mc/*");
	}

}
