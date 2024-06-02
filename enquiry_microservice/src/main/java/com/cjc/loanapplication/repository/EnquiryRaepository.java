package com.cjc.loanapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.loanapplication.model.Enquiry;
@Repository
public interface EnquiryRaepository extends JpaRepository<Enquiry,Integer>{

}
