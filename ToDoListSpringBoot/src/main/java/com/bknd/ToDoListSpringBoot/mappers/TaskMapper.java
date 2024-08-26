package com.bknd.ToDoListSpringBoot.mappers;

import com.bknd.ToDoListSpringBoot.dtos.TaskDto;
import com.bknd.ToDoListSpringBoot.entiites.State;
import com.bknd.ToDoListSpringBoot.entiites.Task;

public class TaskMapper {
	
	public static Task toEntity(TaskDto taskDto) {
		Task task = new Task();
		task.setId(taskDto.getId());
		task.setDescription(taskDto.getDescription());
		task.setState(State.valueOf(taskDto.getState()));
		return task;
	}
	
	public static TaskDto toDto(Task task) {
		TaskDto dto = new TaskDto();
		dto.setId(task.getId());
		dto.setDescription(task.getDescription());
		dto.setState(task.getState().getValue());
		return dto;
	}

}
