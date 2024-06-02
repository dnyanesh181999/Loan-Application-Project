package com.cjc.loanapplication.exceptions;



import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(NoResourcesFoundException.class)
public ResponseEntity<ApiError>noEnquiryFoundException(NoResourcesFoundException e,HttpServletRequest servletReq )
{
ApiError api=new ApiError();
	api.setStatusCode(HttpStatus.BAD_REQUEST.value());
	api.setMessage(e.getMessage());
	api.setDate(new Date());
	api.setPath(servletReq.getRequestURI());
	api.setHttpStatus(HttpStatus.BAD_REQUEST);
	return new ResponseEntity<ApiError>(api,HttpStatus.BAD_REQUEST);
}
}
