package com.bknd.ToDoListSpringBoot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bknd.ToDoListSpringBoot.entiites.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByEmail(String username);

}
