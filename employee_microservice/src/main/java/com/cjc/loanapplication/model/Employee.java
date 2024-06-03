package com.cjc.loanapplication.model;

import com.cjc.loanapplication.enums.UserType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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



@NotEmpty(message = "customerName is mandatory")
@Size(min = 6, message = "customerName must be at min lenght  6 characters only ")
@Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name can only contain letters and spaces")
private String employeeName;



@NotEmpty(message = "Username should be  mandatory")
@Size(min = 6, max=6,message = "userName must be at min lenght  6 characters only ")
private String userName;

@NotEmpty(message = "password should be  mandatory")
@Size(min = 8,max=8, message = "customerName must be at min lenght  8 characters only ")
private String password;


@NotEmpty(message = "Email is mandatory")
@Email(message = "Email should be valid")

private String employeeMail;

@Size(min = 10, max=10 ,message = " mobileno should only  10 digit number long")
@Pattern(regexp ="^[0-9]{10}$",message="contact should only numbers no aphhabets neither special characters")
private String employeeContact;



@Enumerated(EnumType.STRING)
private UserType userType;

}
