package com.bknd.ToDoListSpringBoot.entiites;

public enum State {
	
	NOT_YET_BEGINED("NOT_YET_BEGINED"),
	IN_PROGRESS("IN_PROGRESS"),
	DONE("DONE");
	
	private String value;
	
	State(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	
	

}
