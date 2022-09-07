package com.jpaa.mastercard.mc.web.model;

import java.util.List;

public class Response<T> {

	private List<ExceptionModel> errors;

	private T data;

	public Response() {
		super();
	}

	public Response(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public Response<T> setData(T data) {
		this.data = data;
		return this;
	}

	public List<ExceptionModel> getErrors() {
		return errors;
	}

	public Response<T> setErrors(List<ExceptionModel> errors) {
		this.errors = errors;
		return this;
	}

	@Override
	public String toString() {
		return "Response [errors=" + errors + ", data=" + data + "]";
	}

}
