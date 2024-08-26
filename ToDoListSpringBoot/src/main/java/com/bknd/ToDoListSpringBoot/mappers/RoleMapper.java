package com.bknd.ToDoListSpringBoot.mappers;

import com.bknd.ToDoListSpringBoot.dtos.RoleDto;
import com.bknd.ToDoListSpringBoot.entiites.Role;

public class RoleMapper {
	
	public static Role toEntity(RoleDto dto) {
		Role role = new Role();
		role.setId(dto.getId());
		role.setName(dto.getName());
		return role;
	}
	
	public static RoleDto toDto(Role role) {
		RoleDto roleDto = new RoleDto();
		roleDto.setId(role.getId());
		roleDto.setName(role.getName());
		return roleDto;
		
	}

}
