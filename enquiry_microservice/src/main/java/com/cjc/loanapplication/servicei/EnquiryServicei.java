package com.cjc.loanapplication.servicei;

import java.util.List;

import com.cjc.loanapplication.model.Enquiry;

public interface EnquiryServicei {

	public Enquiry saveEnquriy(Enquiry e);

	public Enquiry getEnquiryById(Integer enquiryId);

	public List<Enquiry> getAllEnquiry();

	public Enquiry getEnquiryByName(String enquiryName);

	public Enquiry updateEnquiry(Integer enquiryId, Enquiry enq);

}
