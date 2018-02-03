package com.foodOnline.app.user.restExceptions;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.foodOnline.app.user.UserNotFoundException;

@RestControllerAdvice
public class CentralizedRestErrorHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	protected final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
		RestErrorResponse error = new RestErrorResponse(HttpStatus.NOT_FOUND.value() , ex.getMessage() );
		return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(Exception.class)
	protected final ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
		RestErrorResponse error = new RestErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value() , ex.getMessage() );
		return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		RestErrorResponse error = new RestErrorResponse(HttpStatus.BAD_REQUEST.value() , ex.getBindingResult().getFieldError().toString() );
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}
	

}
