package com.hodor.ds.list.exceptions;

public class ElementNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ElementNotFoundException() {
		super();
	}

	public ElementNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ElementNotFoundException(String message) {
		super(message);
	}

}
