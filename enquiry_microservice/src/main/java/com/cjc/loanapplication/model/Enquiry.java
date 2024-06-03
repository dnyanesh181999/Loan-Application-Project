package com.cjc.loanapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
private Integer enquiryId;

@NotEmpty(message = "Enquiry name not null and empty")
private String enquiryName;

private Integer age;

@NotEmpty(message = "Enquiry name not null and empty")
@Email(message = "Enter Correct Email Id")
private String email;

@NotEmpty(message = "Enquiry name not null and empty")
@Pattern(regexp = "^[789][0-9]{9}$",message = "Shuld be required 10 Number")
private String mobileNo;

@NotEmpty(message = "Enquiry name not null and empty")
@Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}",message = "Shuld be required 5 letter all Are capital 4 number And 1 Character Capital")
private String pancardNo;

@NotEmpty
@Size(min =12,max=12, message = "Addhar number must be 12 digit")
private String aadharNo;

private Boolean remark;  
private Long cibilScore; 
}
