package com.jpaa.mastercard.mc.web.exception;

import java.util.Collections;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jpaa.mastercard.mc.services.exception.McException;
import com.jpaa.mastercard.mc.services.exception.ParameterValidatorException;
import com.jpaa.mastercard.mc.web.model.ExceptionModel;
import com.jpaa.mastercard.mc.web.model.Response;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);

	@ExceptionHandler(ParameterValidatorException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	protected Response<Void> exceptionHandler(ParameterValidatorException exception, WebRequest request) {
		LOG.error(exception.getMessage(), exception);
		Response<Void> response = new Response<>();
		response.setErrors(exception.getErrors().stream()
				.map(o -> new ExceptionModel(exception.getCode(),
						o.getObjectName() + " - " + o.getCode() + " - " + o.getDefaultMessage()))
				.collect(Collectors.toList()));
		return response;
	}

	@ExceptionHandler(McException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.CONFLICT)
	protected Response<Void> exceptionHandler(McException exception, WebRequest request) {
		LOG.error(exception.getMessage(), exception);
		Response<Void> response = new Response<>();
		response.setErrors(Collections.singletonList(new ExceptionModel(exception.getCode(), exception.getMessage())));
		return response;
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	protected Response<Void> exceptionHandler(Exception exception, WebRequest request) {
		LOG.error(exception.getMessage(), exception);
		Response<Void> response = new Response<>();
		response.setErrors(Collections.singletonList(new ExceptionModel("999", exception.getMessage())));
		return response;
	}

}
