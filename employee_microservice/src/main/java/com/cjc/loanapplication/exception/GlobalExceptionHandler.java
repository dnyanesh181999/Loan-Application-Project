package com.cjc.loanapplication.exception;



import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;

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

	@ExceptionHandler
	 public  ResponseEntity<APIError>  EmployeeNOtSaveException(EmployeeNotSaveExcepiton e,HttpServletRequest request)
	 {
		 APIError error =new APIError();
		 error.setDate(new Date());
		 error.setStatuscode(HttpStatus.BAD_REQUEST.value());
		 error.setMessage(e.getMessage());
		 error.setPath(request.getRequestURI());
		 error.setHttpmessage(HttpStatus.BAD_REQUEST);
		return  new ResponseEntity<APIError>(error,HttpStatus.BAD_REQUEST) ;
	 
 }  
	@ExceptionHandler
	 public   ResponseEntity<Map<String,String>> MethodArgumentNotValidException(org.springframework.web.bind.MethodArgumentNotValidException e,HttpServletRequest request)
	 { 
		Map<String,String> map=new  HashMap<String, String>();
		e.getAllErrors().forEach((error)->{
			String msg=error.getDefaultMessage();
			String ms1=((FieldError) error).getField();
			map.put(msg, ms1);
			
		});
		return  new ResponseEntity<Map<String,String>>(map,HttpStatus.BAD_REQUEST) ;
	 
	 }
	@ExceptionHandler
	public ResponseEntity<APIError>  InvalidEmployeeIdException(InvalidEmployeeIdException e,HttpServletRequest request)
	{
		APIError error =new APIError();
		 error.setDate(new Date());
		 error.setStatuscode(HttpStatus.BAD_REQUEST.value());
		 error.setMessage(e.getMessage());
		 error.setPath(request.getRequestURI());
		 error.setHttpmessage(HttpStatus.BAD_REQUEST);
		return  new ResponseEntity<APIError>(error,HttpStatus.BAD_REQUEST) ;
	 
	}
	@ExceptionHandler
 public ResponseEntity<APIError> NoResourceFoundException(org.springframework.web.servlet.resource.NoResourceFoundException e,HttpServletRequest request)
 {
		APIError error =new APIError();
		 error.setDate(new Date());
		 error.setStatuscode(HttpStatus.BAD_REQUEST.value());
		 error.setMessage(e.getMessage());
		 error.setPath(request.getRequestURI());
		 error.setHttpmessage(HttpStatus.BAD_REQUEST);
		return  new ResponseEntity<APIError>(error,HttpStatus.BAD_REQUEST) ;
 }
	
	@ExceptionHandler
	public ResponseEntity<APIError> NoanyEmployeeDataFoundException(NoAnyEmployeedataFoundException e,HttpServletRequest request)
	{
		APIError error =new APIError();
		 error.setDate(new Date());
		 error.setStatuscode(HttpStatus.BAD_REQUEST.value());
		 error.setMessage(e.getMessage());
		 error.setPath(request.getRequestURI());
		 error.setHttpmessage(HttpStatus.BAD_REQUEST);
		return  new ResponseEntity<APIError>(error,HttpStatus.BAD_REQUEST) ;
	}
	@ExceptionHandler
	public  ResponseEntity<APIError> EmployeeDataNotUpdateException(EmployeeDataNotUpdateException e,HttpServletRequest request)
	{

		APIError error =new APIError();
		 error.setDate(new Date());
		 error.setStatuscode(HttpStatus.BAD_REQUEST.value());
		 error.setMessage(e.getMessage());
		 error.setPath(request.getRequestURI());
		 error.setHttpmessage(HttpStatus.BAD_REQUEST);
		return  new ResponseEntity<APIError>(error,HttpStatus.BAD_REQUEST) ;
	}
	@ExceptionHandler 
	public  ResponseEntity<APIError> TransactionSystemException(org.springframework.transaction.TransactionSystemException e,HttpServletRequest request)
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


		APIError error =new APIError();
		 error.setDate(new Date());
		 error.setStatuscode(HttpStatus.BAD_REQUEST.value());
		 error.setMessage(e.getMessage());
		 error.setPath(request.getRequestURI());
		 error.setHttpmessage(HttpStatus.BAD_REQUEST);
		return  new ResponseEntity<APIError>(error,HttpStatus.BAD_REQUEST) ;
	}
}
