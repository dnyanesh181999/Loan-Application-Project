package com.cjc.loanapplication.servicei;

import com.cjc.loanapplication.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee e);

	Employee getSingleEmployeeData(String userName, String password);

}
