package com.bknd.ToDoListSpringBoot.requests;

public class ChangePasswordRequest {
	
	private String oldPassword;
	private String newPassword;
	private String confirmedPassword;
	
	public ChangePasswordRequest() {
		super();
	}

	public ChangePasswordRequest(String oldPassword, String newPassword, String confirmedPassword) {
		super();
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
		this.confirmedPassword = confirmedPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmedPassword() {
		return confirmedPassword;
	}

	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}
	
	
	
	

}
