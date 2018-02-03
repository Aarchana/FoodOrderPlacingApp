package com.foodOnline.app.user;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 626743969265088395L;
	
	public UserNotFoundException(String message) {
		super(message);
	}

	
}
