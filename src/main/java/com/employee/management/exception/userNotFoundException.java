package com.employee.management.exception;

public class userNotFoundException extends RuntimeException {
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public userNotFoundException(Long id) {
		super("could not  found the user with id"+id);
	}
}
