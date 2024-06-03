package com.cjc.loanapplication.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cjc.loanapplication.model.EmailForEnquiry;
import com.cjc.loanapplication.model.Enquiry;
import com.cjc.loanapplication.servicei.EmailEnquiryServicei;

import jakarta.validation.Valid;
@Service
public class EmailEnquiryServiceImpl implements EmailEnquiryServicei {
@Autowired
private JavaMailSender javaMail;


	

@Override
public void sendEmail( Enquiry e, EmailForEnquiry e1) {
SimpleMailMessage sendMessage=new SimpleMailMessage();
	
	String subject="Loan Inquiry for";
	String text="Dear,"+" "+e.getEnquiryName()+"We are pleased to confirm the receipt of your loan inquiry regarding [Home Loan]. Thank you for considering [Star Finance] for your financial needs.\r\n"
			+ "\r\n"
			+ "Our team is currently reviewing your inquiry and will provide you with detailed information about the loan options, terms, and conditions shortly. Should we require any additional information, one of our representatives will contact you.\r\n"
			+ "\r\n"
			+ "In the meantime, if you have any further questions or need immediate assistance, please do not hesitate to reach out to our customer service team at [9307011693] or via email at [starfinance386@gmail.com].\r\n"
			+ "\r\n"
			+ "Thank you for choosing Star Finance. We look forward to assisting you with your loan requirements.\r\n"
			+ "\r\n"
			+ "Best regards"+"\r\n"
			+ "Star Finanace Limited,";
	sendMessage.setSubject(subject);
	sendMessage.setText(text);
	sendMessage.setTo(e.getEmail());
	javaMail.send(sendMessage);
}
	
}

