package com.cjc.loanapplication.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.loanapplication.exceptions.NoResourcesFoundException;
import com.cjc.loanapplication.model.Enquiry;
import com.cjc.loanapplication.repository.EnquiryRaepository;
import com.cjc.loanapplication.servicei.EnquiryService;
@Service
public class EmployeeServiceimpl implements EnquiryService {
@Autowired
EnquiryRaepository equiryreposit;
	@Override
	public List<Enquiry> getAllEnquiry() {
		List<Enquiry> allEnquiries = equiryreposit.findAll();
		if(!allEnquiries.isEmpty())
		{
			return allEnquiries;
		}
		else {
			throw  new NoResourcesFoundException("No data Available");
		}
	}

}
