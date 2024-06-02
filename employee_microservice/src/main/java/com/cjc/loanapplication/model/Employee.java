package com.cjc.loanapplication.model;

import com.cjc.loanapplication.enums.UserType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
private String employeeName;
private String userName;
private String password;
private String employeeMail;
private Integer employeeContact;
@Enumerated(EnumType.STRING)
private UserType userType;

}
