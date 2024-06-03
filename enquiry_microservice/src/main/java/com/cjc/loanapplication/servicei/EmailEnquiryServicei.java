package com.cjc.loanapplication.servicei;

import com.cjc.loanapplication.model.EmailForEnquiry;
import com.cjc.loanapplication.model.Enquiry;

import jakarta.validation.Valid;

public interface EmailEnquiryServicei {

	void sendEmail(@Valid Enquiry e, EmailForEnquiry e1);

}
