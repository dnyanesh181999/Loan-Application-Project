package com.cjc.loanapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.loanapplication.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
	public Employee findByuserNameAndPassword(String username, String password);

    public Employee findByEmployeeName(String employeeName);

	Employee findByUserNameAndPassword(String userName, String password);

}
