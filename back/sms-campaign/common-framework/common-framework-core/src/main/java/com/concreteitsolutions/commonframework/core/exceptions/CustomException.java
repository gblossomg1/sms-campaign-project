package com.concreteitsolutions.commonframework.core.exceptions;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

	protected final CustomError error;

	public CustomException(final CustomError error) {
		super(error.message());
		this.error = error;
	}

	public CustomException(final CustomError error, final String message) {
		super(message);
		this.error = error;
	}
}
