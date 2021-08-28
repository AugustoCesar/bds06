package com.devsuperior.movieflix.services.exceptions;

public class UnprocessableException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public UnprocessableException(String msg) {
		super(msg);
	}
}
