package com.cjc.loanapplication.exceptions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	//custom exception
	@ExceptionHandler(EnquiryNotSavedException.class)
	public ResponseEntity<APIError>EnquiryNotSavedExceptionHandler(EnquiryNotSavedException e,HttpServletRequest request){
		APIError error = new APIError();
		error.setDate(new Date());
		error.setStatuscode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		error.setHttpmessage(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<APIError>(error,HttpStatus.BAD_REQUEST);
	}
	
	//Custom exception
	@ExceptionHandler(InvalidEnquiryIdException.class)
	public ResponseEntity<APIError>InvalidEnquiryIdExceptionHandler(InvalidEnquiryIdException e,HttpServletRequest request){
		APIError error = new APIError();
		error.setDate(new Date());
		error.setStatuscode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		error.setHttpmessage(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<APIError>(error,HttpStatus.BAD_REQUEST);
	}
	
	
	//This is for Validations 
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>>MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e,HttpServletRequest request){
		Map<String, String>error = new HashMap<String, String>();
		e.getBindingResult().getAllErrors().forEach((er)->{
			String filedName = ((FieldError)er).getField();
			String msg = er.getDefaultMessage();
			error.put(filedName, msg);
		});
		return new ResponseEntity<Map<String,String>>(error,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NoAnyEnquriesFoundException.class)
	public ResponseEntity<APIError>NoAnyEnquriesFoundExceptionHandler(NoAnyEnquriesFoundException e,HttpServletRequest request){
		APIError error = new APIError();
		error.setDate(new Date());
		error.setStatuscode(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		error.setHttpmessage(HttpStatus.NOT_FOUND);
		return new ResponseEntity<APIError>(error,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(EnquiryDataNotUpdateException.class)
	public ResponseEntity<APIError>EnquiryDataNotUpdateExceptionHandler(EnquiryDataNotUpdateException e,HttpServletRequest request){
		APIError error = new APIError();
		error.setDate(new Date());
		error.setStatuscode(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		error.setHttpmessage(HttpStatus.NOT_FOUND);
		return new ResponseEntity<APIError>(error,HttpStatus.NOT_FOUND);
	}
	
	
}
