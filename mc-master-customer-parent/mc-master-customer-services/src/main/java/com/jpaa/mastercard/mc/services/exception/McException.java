package com.jpaa.mastercard.mc.services.exception;

public abstract class McException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String code;

	private final String message;

	public McException(String code, String message) {
		super(code + message);
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
