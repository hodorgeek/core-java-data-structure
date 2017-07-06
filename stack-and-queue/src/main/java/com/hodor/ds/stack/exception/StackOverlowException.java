package com.hodor.ds.stack.exception;

public class StackOverlowException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public StackOverlowException(String message) {
		super(message);
	}

	public StackOverlowException(String message, Throwable cause) {
		super(message, cause);
	}
}
