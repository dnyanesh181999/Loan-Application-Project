package com.cjc.loanapplication.repository;


import org.springframework.data.repository.CrudRepository;

import com.cjc.loanapplication.model.Enquiry;

public interface EnquiryRepository extends CrudRepository<Enquiry, Integer>{

	public Enquiry findByEnquiryName(String enquiryName);

}
