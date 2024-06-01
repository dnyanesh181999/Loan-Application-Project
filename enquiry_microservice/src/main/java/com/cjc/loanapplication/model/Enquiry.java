package com.cjc.loanapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enquiry {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long enquiryId;
private String enquiryName;
private Integer age;
private String email;
private String mobileNo;
private String pancardNo;
private String aadharNo;
private Boolean remark;  
private Long cibilScore; 
}
