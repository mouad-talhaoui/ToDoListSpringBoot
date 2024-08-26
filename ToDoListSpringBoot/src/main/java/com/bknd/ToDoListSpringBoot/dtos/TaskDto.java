package com.bknd.ToDoListSpringBoot.dtos;


public class TaskDto {

	private Long id;
	
	private String description;
	
	private String state;

	public TaskDto(Long id, String description, String state) {
		super();
		this.id = id;
		this.description = description;
		this.state = state;
	}

	public TaskDto(String description, String state) {
		super();
		this.description = description;
		this.state = state;
	}
	
	

	public TaskDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
	
	
	
}
