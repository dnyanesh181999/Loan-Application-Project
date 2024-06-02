package com.cjc.loanapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.loanapplication.model.Enquire;
import com.cjc.loanapplication.servicei.EnquiryServicei;

@RestController
public class EnquiryController
{
	@Autowired
	EnquiryServicei esi;
	
	
	@GetMapping(value="/employee/{employeeId}")
	public ResponseEntity<Enquire> getSingleEmployeeData(@PathVariable Integer employeeId)
	{
		Enquire employee=esi.getSingleEmployeeData(employeeId);
		return new ResponseEntity<Enquire>(employee,HttpStatus.OK);
	}
	
	

}
