package com.bknd.ToDoListSpringBoot.handler;

import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ExceptionResponse {

	private Integer businessErrorCode;
	private String businessErrorDescription;
	private String error;
	private Set<String> validationErrors;
	private Map<String, String> errors;

	public ExceptionResponse() {
		super();
	}

	public ExceptionResponse(Integer businessErrorCode, String businessErrorDescription, String error,
			Set<String> validationErrors, Map<String, String> errors) {
		super();
		this.businessErrorCode = businessErrorCode;
		this.businessErrorDescription = businessErrorDescription;
		this.error = error;
		this.validationErrors = validationErrors;
		this.errors = errors;
	}

	public Integer getBusinessErrorCode() {
		return businessErrorCode;
	}

	public void setBusinessErrorCode(Integer businessErrorCode) {
		this.businessErrorCode = businessErrorCode;
	}

	public String getBusinessErrorDescription() {
		return businessErrorDescription;
	}

	public void setBusinessErrorDescription(String businessErrorDescription) {
		this.businessErrorDescription = businessErrorDescription;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Set<String> getValidationErrors() {
		return validationErrors;
	}

	public void setValidationErrors(Set<String> validationErrors) {
		this.validationErrors = validationErrors;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

}
