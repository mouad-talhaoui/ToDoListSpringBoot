package com.bknd.ToDoListSpringBoot.controllers;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bknd.ToDoListSpringBoot.dtos.TaskDto;
import com.bknd.ToDoListSpringBoot.services.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

	private final TaskService taskService;

	public TaskController(TaskService taskService) {
		super();
		this.taskService = taskService;
	}

	@PostMapping("/create")
	public TaskDto createTask(@RequestBody TaskDto taskDto, Authentication connectedUser) {

		return this.taskService.createTask(taskDto, connectedUser);

	}

	@GetMapping("/view/{id}")
	public TaskDto viewTask(@PathVariable(name = "id") Long id, Authentication connectedUser) {
		return this.taskService.viewTask(id, connectedUser);
	}

	@GetMapping("/view_all")
	public List<TaskDto> viewAllTasks(Authentication connectedUser) {
		return this.taskService.viewAllTasks(connectedUser);
	}

	@GetMapping("/view_all_by_state")
	public List<TaskDto> viewAllTasksByState(Authentication connectedUser, @RequestParam("state") String state) {
		return this.taskService.viewAllTasksByState(connectedUser, state);
	}

	@PostMapping("/update")
	public TaskDto updateTask(@RequestBody TaskDto taskDto, Authentication connectedUser) {
		return this.taskService.updateTask(taskDto, connectedUser);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteTask(@PathVariable(name = "id") Long id, Authentication connectedUser) {
		this.taskService.deleteTask(id, connectedUser);
	}

}
