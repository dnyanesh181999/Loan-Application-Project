package com.cjc.loanapplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmployeeIdNotFoundException.class)
	public ResponseEntity<String> EmployeeIdNotFoundExceptionHandler(EmployeeIdNotFoundException e)
	{
		System.out.println("handle");
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> IllegalArgumentException(IllegalArgumentException e)
	{
		
		System.out.println("in illegal ");
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
