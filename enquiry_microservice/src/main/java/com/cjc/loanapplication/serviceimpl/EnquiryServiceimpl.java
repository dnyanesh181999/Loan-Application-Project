package com.cjc.loanapplication.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.loanapplication.exceptions.EmployeeIdNotFoundException;

import com.cjc.loanapplication.model.Enquire;
import com.cjc.loanapplication.repository.EnquiryRepository;
import com.cjc.loanapplication.servicei.EnquiryServicei;
@Service
public class EnquiryServiceimpl implements EnquiryServicei 
{

	@Autowired
	EnquiryRepository er;
	
	
	@Override
	public Enquire getSingleEmployeeData(Integer employeeId) {
		Optional<Enquire> oe=er.findById(employeeId);
		if(oe.isPresent())
		{
			Enquire employee=oe.get();
			
			return employee;
		}
		else {
		
			throw new EmployeeIdNotFoundException("Employee Id is not available");
		
		}
		
		
	}
}
		

	

	
	


