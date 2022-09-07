package com.jpaa.mastercard.mc.services.exception;

public enum ExceptionCode {

	CUSTOMER_NOT_FOUND_EXCEPTION_CODE("MC0001"), ADDRESS_NOT_FOUND_EXCEPTION_CODE("MC0002"),
	PARAMETER_VALIDATOR_EXCEPTION_CODE("MC0003");

	private String code;

	private ExceptionCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

}
