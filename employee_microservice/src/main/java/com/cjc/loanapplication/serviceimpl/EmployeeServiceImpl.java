package com.cjc.loanapplication.serviceimpl;


import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.loanapplication.exception.EmployeeDataNotUpdateException;
import com.cjc.loanapplication.exception.EmployeeNotSaveExcepiton;

import com.cjc.loanapplication.exception.InvalidEmployeeIdException;
import com.cjc.loanapplication.exception.NoAnyEmployeedataFoundException;

import com.cjc.loanapplication.model.Employee;

import com.cjc.loanapplication.repository.EmployeeRepository;
import com.cjc.loanapplication.servicei.EmployeeService;



@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired
	EmployeeRepository er;

	@Override
	public Employee saveEmployee(Employee e) 
	{
		
		Employee emp=er.save(e);
		if(emp!=null) 
		{
			return emp;
		}
		else {
			throw new EmployeeNotSaveExcepiton("Unable to save Employee");
		}
	}

	
	
	@Override
	public Employee getEmployeeById(String userName, String password)
	{
		
		Employee emp=er.findByuserNameAndPassword(userName, password);
		if(emp!=null)
		{
		return er.findByuserNameAndPassword(userName, password);
		}
		else {
			throw new InvalidEmployeeIdException("Employee Not Found");
		}
	}



	@Override
	public List<Employee> getAllEmployee() {
		List<Employee>list=(List<Employee>) er.findAll();
		if(list.isEmpty())
		{
			throw new NoAnyEmployeedataFoundException("Not found any employees data Found");
		}
		else 
		{
			return list;
		}
	}



	@Override
	public Employee getEmployeeByName(String employeeName) 
	{
		Employee emp=er.findByEmployeeName(employeeName);
		if(emp!=null)
		{
	      return emp;
		}
		else {
			throw new NoAnyEmployeedataFoundException("no any Employees data wuth name "+employeeName);
		}
	
		
	}



	@Override
	public Employee updateEmployee(Integer employeeId, Employee emp) 
	{
		Optional<Employee>ope=er.findById(employeeId);
		if(ope.isPresent())
		{
			Employee em=ope.get();
			if(emp.getEmployeeName()!=null)
			{
				em.setEmployeeName(emp.getEmployeeName());
			}
			if(emp.getUserName()!=null)
			{
				em.setUserName(emp.getUserName());
			}
			if(emp.getPassword()!=null)
			{
				em.setPassword(emp.getPassword());
			}
			if(emp.getEmployeeMail()!=null)
			{
				em.setEmployeeMail(emp.getEmployeeMail());
			}
			if(emp.getEmployeeContact()!=null)
			{
				em.setEmployeeContact(emp.getEmployeeContact());
			}
			if(emp.getUserType()!=null)
			{
				em.setUserType(emp.getUserType());
			}
			 Employee empp=er.save(em);
			 if(empp!=null)
			 {
					return empp;
				 
			 }
			 else {
				 throw new  EmployeeDataNotUpdateException("Due to database problem Data not updated");
			 }
		}
		else {
			throw new NoAnyEmployeedataFoundException("no any Employee  found for update  operation");
		}
		
	
	
	}
	

	
	
	

}
