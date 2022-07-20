package com.capgemini.gharkakhanaapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AdminIdException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AdminIdException() {
		super();
	}
	
	public AdminIdException(String errMsg) {
		super(errMsg);
	}

}
