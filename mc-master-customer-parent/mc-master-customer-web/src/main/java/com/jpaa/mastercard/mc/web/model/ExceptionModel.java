package com.jpaa.mastercard.mc.web.model;

public class ExceptionModel {

	private String code;
	private String message;

	public ExceptionModel() {
		super();
	}

	public ExceptionModel(String code) {
		this.code = code;
		this.message = "";
	}

	public ExceptionModel(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ExceptionModel [code=" + code + ", message=" + message + "]";
	}

}
