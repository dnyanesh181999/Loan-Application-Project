package com.cjc.loanapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.loanapplication.model.Employee;
import com.cjc.loanapplication.servicei.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/employee")
public class EmployeeController 
{
	@Autowired
	EmployeeService es;

	@PostMapping("/employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee e)
	{
		Employee employee= es.saveEmployee(e);
		if(employee!=null)
		{
			log.info("New Employee saved succesfully");
			return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
		}
		else {
			log.info("Failed to save Employee ");
			return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/employee/{userName}/{password}")
	public ResponseEntity<Employee> getSingleEmployeeData(@PathVariable String userName,@PathVariable String password)
	{
		Employee employee=es.getSingleEmployeeData(userName,password);
		if(employee!=null)
		{
			log.info(" Getting Employee Username and Password Succesfully");
			return new ResponseEntity<Employee>(employee,HttpStatus.FOUND);
		}
		else {
			log.info("Wrong data found");
			return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
		}
		
		
	}
}
