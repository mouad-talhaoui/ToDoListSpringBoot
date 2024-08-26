package com.bknd.ToDoListSpringBoot.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bknd.ToDoListSpringBoot.Security.JwtService;
import com.bknd.ToDoListSpringBoot.dtos.UserDto;
import com.bknd.ToDoListSpringBoot.entiites.Role;
import com.bknd.ToDoListSpringBoot.entiites.User;
import com.bknd.ToDoListSpringBoot.exceptions.PasswordNotMatchException;
import com.bknd.ToDoListSpringBoot.mappers.UserMapper;
import com.bknd.ToDoListSpringBoot.repositories.RoleRepository;
import com.bknd.ToDoListSpringBoot.repositories.UserRepository;
import com.bknd.ToDoListSpringBoot.requests.AuthenticationRequest;
import com.bknd.ToDoListSpringBoot.requests.ChangePasswordRequest;
import com.bknd.ToDoListSpringBoot.requests.RegistrationRequest;
import com.bknd.ToDoListSpringBoot.responses.AuthenticationResponse;

@Service
public class AuthenticationService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	private final RoleRepository roleRepository;

	public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService,
			AuthenticationManager authenticationManager, RoleRepository roleRepository) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
		this.authenticationManager = authenticationManager;
		this.roleRepository = roleRepository;
	}

	public void register(RegistrationRequest request) {
		Role userRole = roleRepository.findByName("USER")
				.orElseThrow(() -> new IllegalStateException("ROLE USER was not initiated"));
		User user = new User(request.getDateOfBirth(), request.getEmail(), request.getFirstname(),
				request.getLastname(), passwordEncoder.encode(request.getPassword()), false, true, List.of(userRole));
		userRepository.save(user);
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		Authentication auth = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

		Map<String, Object> claims = new HashMap<String, Object>();
		User user = ((User) auth.getPrincipal());
		claims.put("fullName", user.getFirstname() + " " + user.getLastname());
		String jwtToken = jwtService.generateToken(claims, (User) auth.getPrincipal());
		return new AuthenticationResponse(jwtToken);
	}

	public void changePassword(Authentication connectedUser, ChangePasswordRequest changePasswordRequest) {

		User user = (User) connectedUser.getPrincipal();
		if (!passwordEncoder.matches(user.getPassword(),
				passwordEncoder.encode(changePasswordRequest.getOldPassword()))) {
			throw new PasswordNotMatchException("old password and current password does not match");
		}
		if (!changePasswordRequest.getNewPassword().equals(changePasswordRequest.getConfirmedPassword())) {
			throw new PasswordNotMatchException("new password and confirmed does not match");
		}
		if (!passwordEncoder.matches(user.getPassword(), changePasswordRequest.getConfirmedPassword())) {
			throw new PasswordNotMatchException("new password and old password does not match");
		}
	}
	
	public UserDto updateProfil(Authentication connectedUser, UserDto dto) {
		User user = UserMapper.toEntity(dto);
		User user1 = (User) connectedUser.getPrincipal();
		user.setPassword(user1.getPassword());
		return UserMapper.toDto(user1);
	}

}
