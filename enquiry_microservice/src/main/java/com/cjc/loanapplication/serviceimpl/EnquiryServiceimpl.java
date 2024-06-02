package com.cjc.loanapplication.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.loanapplication.exceptions.EnquiryDataNotUpdateException;
import com.cjc.loanapplication.exceptions.EnquiryNotSavedException;
import com.cjc.loanapplication.exceptions.InvalidEnquiryIdException;
import com.cjc.loanapplication.exceptions.NoAnyEnquriesFoundException;
import com.cjc.loanapplication.model.Enquiry;
import com.cjc.loanapplication.repository.EnquiryRepository;
import com.cjc.loanapplication.servicei.EnquiryServicei;
@Service
public class EnquiryServiceimpl implements EnquiryServicei{
	
	@Autowired
	EnquiryRepository er;

	@Override
	public Enquiry saveEnquriy(Enquiry e) {
		Enquiry enq=er.save(e);
		if(enq!=null) {
			return enq;
		}
		else {
			throw new EnquiryNotSavedException("Unable to save Enquiry");
		}
	}

	@Override
	public Enquiry getEnquiryById(Integer enquiryId) {
		
		Optional<Enquiry> optional = er.findById(enquiryId);
		if(optional.isPresent()) {
			Enquiry enquiry = optional.get();
			return enquiry;
		}
		else {
			throw new InvalidEnquiryIdException("Enquiry Not Found");
		}
		
		
	}

	@Override
	public List<Enquiry> getAllEnquiry() {
		List<Enquiry>list=(List<Enquiry>) er.findAll();
		if(list.isEmpty()) {
			throw new NoAnyEnquriesFoundException("No Enquries Found");
		}
		else {
			return list;
		}
	}

	@Override
	public Enquiry getEnquiryByName(String enquiryName) {
		Enquiry enq = er.findByEnquiryName(enquiryName);
		if(enq!=null) {
		
			return enq;
		}
		else {
			throw new NoAnyEnquriesFoundException("No any enquries found with name:"+enquiryName);
		}
	}

	@Override
	public Enquiry updateEnquiry(Integer enquiryId, Enquiry enq) {
		
		Optional<Enquiry>opt=er.findById(enquiryId);
		if(opt.isPresent()) {
			Enquiry en=opt.get();
			
			if(enq.getEnquiryName()!=null) {
				en.setEnquiryName(enq.getEnquiryName());
			}
			if(enq.getAadharNo()!=null) {
				en.setAadharNo(enq.getAadharNo());
			}
			if(enq.getAge()!=null) {
				en.setAge(enq.getAge());
			}
			if(enq.getEmail()!=null) {
				en.setEmail(enq.getEmail());
			}
			if(enq.getMobileNo()!=null)
			{
				en.setMobileNo(enq.getMobileNo());
			}
			if(enq.getPancardNo()!=null)
			{
				en.setPancardNo(enq.getPancardNo());
			}
			if(enq.getRemark()!=null)
			{
				en.setRemark(enq.getRemark());
			}
			if(enq.getCibilScore()!=null)
			{
				en.setCibilScore(enq.getCibilScore());
			}
				Enquiry enqu=er.save(en);
				if(enqu!=null) {
					return enqu;
				}
				else {
					throw new EnquiryDataNotUpdateException("Due to database problem Data not updated");
				}
		}
		else {
			throw new NoAnyEnquriesFoundException("No any enquries found for update operation");
		}
		
	}
	

}
