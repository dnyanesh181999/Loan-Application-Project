package com.cjc.loanapplication.model;

import com.cjc.loanapplication.enums.UserType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer employeeId;
//@NotEmpty(message = "")
private String employeeName;
//@NotEmpty(message = "")
private String userName;
//@NotEmpty(message = "")
private String password;
//@NotEmpty(message = "")
private String employeeMail;
//@NotEmpty(message = "")
private Long employeeContact;
//@NotEmpty(message = "")
@Enumerated(EnumType.STRING)
private UserType userType;

}
