package com.jpaa.mastercard.mc.services.exception;

public class CustomerNotFoundException extends McException {

	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(String customer) {
		super(ExceptionCode.CUSTOMER_NOT_FOUND_EXCEPTION_CODE.getCode(), "Customer " + customer + " not found");
	}

}
