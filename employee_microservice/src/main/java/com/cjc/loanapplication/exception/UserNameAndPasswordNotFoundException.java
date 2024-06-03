package com.cjc.loanapplication.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class UserNameAndPasswordNotFoundException extends RuntimeException 
{
	
	public UserNameAndPasswordNotFoundException(String msg)
	{
		super(msg);
	}

}
