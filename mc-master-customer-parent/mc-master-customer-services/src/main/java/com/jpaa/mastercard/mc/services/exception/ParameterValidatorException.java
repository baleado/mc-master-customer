package com.jpaa.mastercard.mc.services.exception;

import java.util.List;

import org.springframework.validation.ObjectError;

public class ParameterValidatorException extends McException {

	private static final long serialVersionUID = 1L;

	private final List<ObjectError> errors;

	public ParameterValidatorException(List<ObjectError> errors) {
		super(ExceptionCode.PARAMETER_VALIDATOR_EXCEPTION_CODE.getCode(), "Parameter validation error");
		this.errors = errors;
	}

	public List<ObjectError> getErrors() {
		return errors;
	}

}
