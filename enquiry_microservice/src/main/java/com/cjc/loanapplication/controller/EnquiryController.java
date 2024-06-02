package com.cjc.loanapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.loanapplication.model.Enquiry;
import com.cjc.loanapplication.servicei.EnquiryService;



@RestController
@RequestMapping("/enquiry")
public class EnquiryController {
	@Autowired
	EnquiryService esi;
@GetMapping("/enquiry")
public ResponseEntity<List<Enquiry>> getEnquiryById(){
		List<Enquiry> allEnquiry = esi.getAllEnquiry();
		
			return new ResponseEntity<List<Enquiry>>(allEnquiry,HttpStatus.OK);
	
}
}
