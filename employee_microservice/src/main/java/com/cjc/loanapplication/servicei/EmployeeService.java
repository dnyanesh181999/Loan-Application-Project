package com.cjc.loanapplication.servicei;

import java.util.List;

import com.cjc.loanapplication.model.Employee;

import jakarta.validation.Valid;

public interface EmployeeService {

	 public Employee saveEmployee(@Valid Employee e);

	public Employee getEmployeeById(String userName, String password);

	public List<Employee> getAllEmployee();

	public Employee getEmployeeByName(String employeeName);

	public Employee updateEmployee(Integer employeeId, Employee emp);


import com.cjc.loanapplication.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee e);

	Employee getSingleEmployeeData(String userName, String password);


}
