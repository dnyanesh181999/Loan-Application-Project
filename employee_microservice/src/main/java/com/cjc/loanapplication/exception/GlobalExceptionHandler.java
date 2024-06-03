package com.cjc.loanapplication.exception;

import java.net.http.HttpResponse;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler 
{
	@ExceptionHandler(EmployeeNotSaveException.class)
	public ResponseEntity<APIError> employeeNotSavedExceptionHandler(EmployeeNotSaveException e,HttpServletRequest request)
	{
		APIError apierror=new APIError();
		apierror.setDate(new Date());
		apierror.setStatuscode(HttpStatus.BAD_REQUEST.value());
		apierror.setMessage(e.getMessage());
		apierror.setPath(request.getRequestURI());
		apierror.setHttpmessage(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<APIError>(apierror,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserNameAndPasswordNotFoundException.class)
	public ResponseEntity<APIError> usernameANdPasswordNotFoundExceptionHandler(UserNameAndPasswordNotFoundException e,HttpServletRequest request)
	{
		APIError apierror=new APIError();
		apierror.setDate(new Date());
		apierror.setStatuscode(HttpStatus.BAD_REQUEST.value());
		apierror.setMessage(e.getMessage());
		apierror.setPath(request.getRequestURI());
		apierror.setHttpmessage(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<APIError>(apierror,HttpStatus.BAD_REQUEST);
	}

}
