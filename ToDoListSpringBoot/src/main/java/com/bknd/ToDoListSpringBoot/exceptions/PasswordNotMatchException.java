package com.bknd.ToDoListSpringBoot.exceptions;

public class PasswordNotMatchException extends RuntimeException {
	
	public PasswordNotMatchException(String msg) {
		super(msg);
	}

}
