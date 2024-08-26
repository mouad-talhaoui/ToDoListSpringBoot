package com.bknd.ToDoListSpringBoot.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import com.bknd.ToDoListSpringBoot.exceptions.RoleException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(RoleException.class)
	public ResponseEntity<ExceptionResponse> handleException(RoleException exp) {
		return ResponseEntity.status(UNAUTHORIZED)
				.body(new ExceptionResponse(null, null, exp.getMessage(), null, null));
	}
}
