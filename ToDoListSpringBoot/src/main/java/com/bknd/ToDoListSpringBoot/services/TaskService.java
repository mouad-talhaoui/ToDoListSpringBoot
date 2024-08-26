package com.bknd.ToDoListSpringBoot.services;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.bknd.ToDoListSpringBoot.dtos.TaskDto;
import com.bknd.ToDoListSpringBoot.entiites.State;
import com.bknd.ToDoListSpringBoot.entiites.Task;
import com.bknd.ToDoListSpringBoot.entiites.User;
import com.bknd.ToDoListSpringBoot.exceptions.RoleException;
import com.bknd.ToDoListSpringBoot.exceptions.TaskException;
import com.bknd.ToDoListSpringBoot.mappers.TaskMapper;
import com.bknd.ToDoListSpringBoot.repositories.TaskRepository;

@Service
public class TaskService {
	private final TaskRepository taskRepository;

	public TaskService(TaskRepository taskRepository) {
		super();
		this.taskRepository = taskRepository;
	}

	public TaskDto createTask(TaskDto dto, Authentication connectedUser) {
		if (dto.getId() != null)
			throw new TaskException("new task can not have an id");
		Task task = TaskMapper.toEntity(dto);
		User user = (User) connectedUser.getPrincipal();
		task.setOwner(user);
		Task newTask = taskRepository.save(task);
		return TaskMapper.toDto(newTask);
	}

	public TaskDto viewTask(Long id, Authentication connectedUser) {
		User user = (User) connectedUser.getPrincipal();
		Task task = taskRepository.findById(id).get();
		if (!task.getOwner().getId().equals(user.getId())) {
			throw new TaskException("you can only view your own tasks");
		}
		TaskDto taskDto = TaskMapper.toDto(task);
		return taskDto;
	}

	public List<TaskDto> viewAllTasks(Authentication connectedUser) {
		User user = (User) connectedUser.getPrincipal();
		List<Task> tasks = taskRepository.findByOwner(user);
		return tasks.stream().map(elt -> TaskMapper.toDto(elt)).toList();
	}

	public List<TaskDto> viewAllTasksByState(Authentication connectedUser, String state) {
		User user = (User) connectedUser.getPrincipal();
		List<Task> tasks = taskRepository.findByOwnerAndState(user, State.valueOf(state));
		return tasks.stream().map(elt -> TaskMapper.toDto(elt)).toList();
	}

	public TaskDto updateTask(TaskDto dto, Authentication connectedUser) {
		User user = (User) connectedUser.getPrincipal();
		if (dto.getId() == null)
			throw new RoleException("updated task should have an id");
		Task task = TaskMapper.toEntity(dto);
		if (!task.getOwner().getId().equals(user.getId())) {
			throw new TaskException("you can only update your own tasks");
		}
		Task newTask = taskRepository.save(task);
		return TaskMapper.toDto(newTask);
	}

	public void deleteTask(Long id, Authentication connectedUser) {
		User user = (User) connectedUser.getPrincipal();
		Task task = taskRepository.findById(id).get();
		if (!task.getOwner().getId().equals(user.getId())) {
			throw new TaskException("you can only delete your own tasks");
		}
		taskRepository.delete(task);
	}
}
