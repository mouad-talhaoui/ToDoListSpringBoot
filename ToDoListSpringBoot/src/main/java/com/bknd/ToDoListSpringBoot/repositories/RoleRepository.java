package com.bknd.ToDoListSpringBoot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bknd.ToDoListSpringBoot.entiites.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
	public Optional<Role> findByName(String name);

}
