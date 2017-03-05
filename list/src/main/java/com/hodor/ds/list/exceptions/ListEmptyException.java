package com.hodor.ds.list.exceptions;

public class ListEmptyException extends RuntimeException {

	private static final long serialVersionUID = 6459277725058391115L;

	public ListEmptyException() {
		super();
	}

	public ListEmptyException(String message, Throwable cause) {
		super(message, cause);
	}

	public ListEmptyException(String message) {
		super(message);
	}

}
