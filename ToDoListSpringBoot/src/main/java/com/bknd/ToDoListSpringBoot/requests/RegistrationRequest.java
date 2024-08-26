package com.bknd.ToDoListSpringBoot.requests;


import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RegistrationRequest {


    @NotEmpty(message = "Firstname is mandatory")
    @NotNull(message = "Firstname is mandatory")
    private String firstname;
    @NotEmpty(message = "Lastname is mandatory")
    @NotNull(message = "Lastname is mandatory")
    private String lastname;
    @Email(message = "Email is not well formatted")
    @NotEmpty(message = "Email is mandatory")
    @NotNull(message = "Email is mandatory")
    private String email;
    @NotEmpty(message = "Password is mandatory")
    @NotNull(message = "Password is mandatory")
    @Size(min = 8, message = "Password should be 8 characters long minimum")
    private String password;
    
    @NotNull(message = "dateOfBirth is mandatory")
    private LocalDate dateOfBirth;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public RegistrationRequest(
			@NotEmpty(message = "Firstname is mandatory") @NotNull(message = "Firstname is mandatory") String firstname,
			@NotEmpty(message = "Lastname is mandatory") @NotNull(message = "Lastname is mandatory") String lastname,
			@Email(message = "Email is not well formatted") @NotEmpty(message = "Email is mandatory") @NotNull(message = "Email is mandatory") String email,
			@NotEmpty(message = "Password is mandatory") @NotNull(message = "Password is mandatory") @Size(min = 8, message = "Password should be 8 characters long minimum") String password,
			@NotEmpty(message = "dateOfBirth is mandatory") @NotNull(message = "dateOfBirth is mandatory") LocalDate dateOfBirth) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
	}

	public RegistrationRequest() {
		super();
	}
    
    
    
    
}