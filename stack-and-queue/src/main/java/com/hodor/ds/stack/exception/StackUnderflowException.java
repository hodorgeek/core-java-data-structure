package com.hodor.ds.stack.exception;

public class StackUnderflowException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public StackUnderflowException(String message, Throwable cause) {
		super(message, cause);
	}

	public StackUnderflowException(String message) {
		super(message);
	}
}
