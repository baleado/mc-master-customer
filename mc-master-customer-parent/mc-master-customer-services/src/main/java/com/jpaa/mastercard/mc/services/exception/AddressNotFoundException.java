package com.jpaa.mastercard.mc.services.exception;

public class AddressNotFoundException extends McException {

	private static final long serialVersionUID = 1L;

	public AddressNotFoundException(String customer) {
		super(ExceptionCode.ADDRESS_NOT_FOUND_EXCEPTION_CODE.getCode(), "Address " + customer + " not found");
	}
}
