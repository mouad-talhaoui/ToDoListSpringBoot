package com.bknd.ToDoListSpringBoot.services;

import org.springframework.stereotype.Service;

import com.bknd.ToDoListSpringBoot.dtos.RoleDto;
import com.bknd.ToDoListSpringBoot.entiites.Role;
import com.bknd.ToDoListSpringBoot.exceptions.RoleException;
import com.bknd.ToDoListSpringBoot.mappers.RoleMapper;
import com.bknd.ToDoListSpringBoot.repositories.RoleRepository;

@Service
public class RoleService {
	
	private final RoleRepository roleRepository;

	public RoleService(RoleRepository roleRepository) {
		super();
		this.roleRepository = roleRepository;
	}
	
	public RoleDto createRole(RoleDto dto) {
		if(dto.getId()!=null)
			throw new RoleException("new role can not have an id");
		Role role = RoleMapper.toEntity(dto);
		Role newRole = roleRepository.save(role);
		return RoleMapper.toDto(newRole);
	}
	
	public RoleDto viewRole(Long id) {
		Role role = roleRepository.findById(id).get();
		RoleDto roleDto = RoleMapper.toDto(role);
		return roleDto;
	}
	
	public RoleDto updateRole(RoleDto dto) {
		if(dto.getId()==null)
			throw new RoleException("updated role should have an id");
		Role role = RoleMapper.toEntity(dto);
		Role newRole = roleRepository.save(role);
		return RoleMapper.toDto(newRole);
	}
	
	public void deleteRole(Long id) {
		roleRepository.deleteById(id);
	}
	
	
	
	
	
	

}
