package com.bknd.ToDoListSpringBoot.dtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDto {
private Long id;
	
	private String email;
	
	private String firstname;
	
	private String lastname;
	private boolean accountLocked;
    private boolean enabled;
    private LocalDate dateOfBirth;
	
	private List<RoleDto> roleDtos = new ArrayList<>();

	
	
	public UserDto() {
		super();
	}
	
	

	public UserDto(String email, String firstname, String lastname, boolean accountLocked,
			boolean enabled, LocalDate dateOfBirth, List<RoleDto> roleDtos) {
		super();
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.accountLocked = accountLocked;
		this.enabled = enabled;
		this.dateOfBirth = dateOfBirth;
		this.roleDtos = roleDtos;
	}
	
	



	public UserDto(Long id, String email, String firstname, String lastname, boolean accountLocked,
			boolean enabled, LocalDate dateOfBirth, List<RoleDto> roleDtos) {
		super();
		this.id = id;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.accountLocked = accountLocked;
		this.enabled = enabled;
		this.dateOfBirth = dateOfBirth;
		this.roleDtos = roleDtos;
	}



	public Long getId() {
		return id;
	}
	
	

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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

	public List<RoleDto> getRoleDtos() {
		return roleDtos;
	}

	public void setRoleDtos(List<RoleDto> roleDtos) {
		this.roleDtos = roleDtos;
	}



	public boolean isAccountLocked() {
		return accountLocked;
	}



	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}



	public boolean isEnabled() {
		return enabled;
	}



	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}



	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
	
	
}
