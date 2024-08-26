package com.bknd.ToDoListSpringBoot.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bknd.ToDoListSpringBoot.dtos.RoleDto;
import com.bknd.ToDoListSpringBoot.services.RoleService;

@RestController
@RequestMapping("/role")
@PreAuthorize("hasAuthority('ADMIN')")
public class RoleController {

	private final RoleService roleService;

	public RoleController(RoleService roleService) {
		super();
		this.roleService = roleService;
	}

	@PostMapping("/create")
	public RoleDto createRole(@RequestBody RoleDto roleDto) {

		return roleService.createRole(roleDto);
	}

	@GetMapping("/view/{id}")
	public RoleDto viewRole(@PathVariable(name = "id") Long id) {
		return roleService.viewRole(id);
	}

	@PostMapping("/update")
	public RoleDto updateRole(@RequestBody RoleDto roleDto) {
		return roleService.updateRole(roleDto);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteRole(@PathVariable(name = "id") Long id) {
		roleService.deleteRole(id);
	}

}
