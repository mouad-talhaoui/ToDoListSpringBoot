package com.bknd.ToDoListSpringBoot.mappers;

import com.bknd.ToDoListSpringBoot.dtos.UserDto;
import com.bknd.ToDoListSpringBoot.entiites.User;

public class UserMapper {
	
	public static UserDto toDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setDateOfBirth(user.getDateOfBirth());
		userDto.setEmail(user.getEmail());
		userDto.setFirstname(user.getFirstname());
		userDto.setLastname(user.getLastname());
		userDto.setAccountLocked(user.isAccountLocked());
		userDto.setEnabled(user.isEnabled());
		userDto.setRoleDtos(user.getRoles().stream().map(elt->RoleMapper.toDto(elt)).toList());
		return userDto;
	}
	
	public static User toEntity(UserDto dto) {
		User user =new User();
		user.setId(dto.getId());
		user.setAccountLocked(dto.isAccountLocked());
		user.setEnabled(dto.isEnabled());
		user.setEmail(dto.getEmail());
		user.setFirstname(dto.getFirstname());
		user.setLastname(dto.getLastname());
		user.setDateOfBirth(dto.getDateOfBirth());
		user.setRoles(dto.getRoleDtos().stream().map(elt->RoleMapper.toEntity(elt)).toList());
		return user;
		
	}

}
