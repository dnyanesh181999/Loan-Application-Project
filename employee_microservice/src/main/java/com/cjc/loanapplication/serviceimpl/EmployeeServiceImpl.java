package com.cjc.loanapplication.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.loanapplication.exception.EmployeeNotSaveException;
import com.cjc.loanapplication.exception.UserNameAndPasswordNotFoundException;
import com.cjc.loanapplication.model.Employee;
import com.cjc.loanapplication.repository.EmployeeRepository;
import com.cjc.loanapplication.servicei.EmployeeService;

import lombok.extern.java.Log;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository er;
	
	@Override
	public Employee saveEmployee(Employee e) {
		
		Employee emp=er.save(e);
		if(emp!=null)
		{
			return emp;
		}
		else {
			throw new EmployeeNotSaveException("Not save Data");
		}
		
	}

	@Override
	public Employee getSingleEmployeeData(String userName, String password)
	{
		Employee emp = er.findByUserNameAndPassword(userName, password);
		if(emp!=null)
		{
			return emp;
		}else {
			
			throw new UserNameAndPasswordNotFoundException("NOt found username password");
			
		}
	
	
	}

}
