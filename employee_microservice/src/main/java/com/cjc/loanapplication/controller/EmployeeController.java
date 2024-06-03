package com.cjc.loanapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cjc.loanapplication.exception.EmployeeDataNotUpdateException;
import com.cjc.loanapplication.model.Employee;

import com.cjc.loanapplication.model.Employee;
import com.cjc.loanapplication.servicei.EmployeeService;

import lombok.extern.slf4j.Slf4j;


import com.cjc.loanapplication.servicei.EmployeeService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequestMapping("/employee")

@RestController

public class EmployeeController
{
	@Autowired
	EmployeeService ei;
	@PostMapping(value="/saveEmployee")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee e)
	{
		Employee emp=ei.saveEmployee(e);
		if(emp!=null)
		{
			log.info("new Employee data added sucessfully");
			return new ResponseEntity<Employee> (emp,HttpStatus.CREATED);

		}
		else {
			log.error("failed to added data of employee");
			return new ResponseEntity<Employee> (HttpStatus.BAD_REQUEST);
			}
	}
	
	
	
	
	
	@GetMapping(value="/employee/{userName}/{password}")
	public ResponseEntity<Employee>  getEmployeeById(@PathVariable String userName,@PathVariable String password  )
	{ 
		
			Employee emp=ei.getEmployeeById(userName,password);
			if(emp!=null)
			{
				log.info("Getting employee data  By username and password Succesfully");
				return new ResponseEntity<Employee> (emp,HttpStatus.FOUND);
				
			}
			else {
				log.warn("no any employee  data found");
				return new ResponseEntity<Employee> (HttpStatus.BAD_REQUEST);
			}	
  }
	
	
	
	
	
	@GetMapping(value="/employees")
	public ResponseEntity<List<Employee>> getAllEmployee()
	{
		List<Employee> listEmp=ei.getAllEmployee();
		log.info("Fetch all employee data in from database");
		 return new ResponseEntity<List<Employee>> (listEmp,HttpStatus.CREATED);
		}
	

	
	
	
	
	
	
@GetMapping(value = "/employeeByName/{employeeName}")
public ResponseEntity<Employee>   getEmployeeByName(@PathVariable String employeeName){
	Employee emp = ei.getEmployeeByName(employeeName);
	if(emp!=null) {
		log.info("Fetching Employees data By EmployeeName sucessfully");
		return new ResponseEntity<Employee>(emp,HttpStatus.FOUND);
	}
	else {
		log.error("Fetching Employees data By EmployeeName Failed");
		return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
	}

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




@PutMapping(value ="/employee/{employeeId}")
public ResponseEntity<Employee>    updateEmployee(@PathVariable Integer employeeId,@RequestBody Employee emp){
	 
	Employee em = ei.updateEmployee(employeeId,emp);
	if(em==null) 
	{
		log.error("Employee Details failed to update");
		throw new EmployeeDataNotUpdateException("Employee Data not updated");
	}
	else 
	{
		
		log.info("Enquiry Details updated sucessfully");
		return new ResponseEntity<Employee>(em,HttpStatus.FOUND);
	}
			
}



	
	
	
}

