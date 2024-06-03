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

import com.cjc.loanapplication.exceptions.EnquiryDataNotUpdateException;
import com.cjc.loanapplication.exceptions.InvalidEnquiryIdException;
import com.cjc.loanapplication.model.EmailForEnquiry;
import com.cjc.loanapplication.model.Enquiry;
import com.cjc.loanapplication.servicei.EmailEnquiryServicei;
import com.cjc.loanapplication.servicei.EnquiryServicei;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequestMapping("enquiry")
@RestController
public class EnquiryController {
	
	@Autowired
	EnquiryServicei es;

	@Autowired
	EmailEnquiryServicei esi;

	@PostMapping(value ="/enquiry")

	
	public ResponseEntity<Enquiry> saveEnquiry(@Valid @RequestBody Enquiry e, EmailForEnquiry e1) {

		e.setCibilScore((long)0);
		e.setRemark(false);
		Enquiry enq=es.saveEnquriy(e);
		if(enq!=null) 
		{
			log.info("new enquiry saved sucessfully ");
			esi.sendEmail(e,e1);
			
			return new ResponseEntity<Enquiry>(enq,HttpStatus.CREATED);
		}
		else {
			log.error("Failed to saved enquiry");
			return new ResponseEntity<Enquiry>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	
	
	
	@GetMapping(value ="/enquiry/{enquiryId}")
	public ResponseEntity<Enquiry> getEnquiryById(@PathVariable Integer enquiryId){
		if(enquiryId>0) {
			Enquiry enquiry =es.getEnquiryById(enquiryId);
			if(enquiry!=null) {
				log.info("Getting enquiry By Id sucessfully");
				return new ResponseEntity<Enquiry>(enquiry,HttpStatus.FOUND);
			}
			else {
				log.warn("No any enquiry data found");
				return new ResponseEntity<Enquiry>(HttpStatus.BAD_REQUEST);
			}
		}
		else {
			log.error("enquiry ID incorrect");
			throw new InvalidEnquiryIdException("Enquiry ID should be grater than 0");
		}
	}
	
	
	
	
	@GetMapping(value = "/enquiries")
	public ResponseEntity<List<Enquiry>>getAllEnquiry(){
		
		List<Enquiry>listEnquires=es.getAllEnquiry();
		log.info("Fetching all enquries from database");
		return new ResponseEntity<List<Enquiry>>(listEnquires,HttpStatus.OK);
		
	}
	
	
	
	@GetMapping(value = "/enquiryByName/{enquiryName}")
	public ResponseEntity<Enquiry>getEnquiryByName(@PathVariable String enquiryName){
		Enquiry enquiry = es.getEnquiryByName(enquiryName);
		if(enquiry!=null) {
			log.info("Fetching enquiry By enquiryName sucessfully");
			return new ResponseEntity<Enquiry>(enquiry,HttpStatus.FOUND);
		}
		else {
			log.error("Fetching enquiry By enquiryName Failed");
			return new ResponseEntity<Enquiry>(HttpStatus.BAD_REQUEST);
		}
	
	
	}
	
	
	
	
	@PutMapping(value ="/enquiry/{enquiryId}")
	public ResponseEntity<Enquiry>updateEnquiry(@PathVariable Integer enquiryId,@RequestBody Enquiry enq){
		 
		Enquiry en = es.updateEnquiry(enquiryId,enq);
		if(en==null) {
			log.error("Enquiry Details failed to update");
			throw new EnquiryDataNotUpdateException("Enquiry Data not updated");
		}
		else {
			
			log.info("Enquiry Details updated sucessfully");
			return new ResponseEntity<Enquiry>(en,HttpStatus.FOUND);
		}
				
	}
	
	
	
}
