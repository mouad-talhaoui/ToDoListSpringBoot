package com.bknd.ToDoListSpringBoot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bknd.ToDoListSpringBoot.entiites.State;
import com.bknd.ToDoListSpringBoot.entiites.Task;
import com.bknd.ToDoListSpringBoot.entiites.User;

public interface TaskRepository extends JpaRepository<Task, Long>{
	
	List<Task> findByOwner(User user);
	List<Task> findByOwnerAndState(User user, State state);

}
