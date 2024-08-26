package com.bknd.ToDoListSpringBoot.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.bknd.ToDoListSpringBoot.dtos.UserDto;
import com.bknd.ToDoListSpringBoot.requests.AuthenticationRequest;
import com.bknd.ToDoListSpringBoot.requests.ChangePasswordRequest;
import com.bknd.ToDoListSpringBoot.requests.RegistrationRequest;
import com.bknd.ToDoListSpringBoot.responses.AuthenticationResponse;
import com.bknd.ToDoListSpringBoot.services.AuthenticationService;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

	private final AuthenticationService service;

	public AuthenticationController(AuthenticationService service) {
		super();
		this.service = service;
	}

	@PostMapping("/register")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseEntity<?> register(@RequestBody @Valid RegistrationRequest request) {
		service.register(request);
		return ResponseEntity.accepted().build();
	}

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
		return ResponseEntity.ok(service.authenticate(request));
	}

	@PostMapping("/changePassword")
	public void changePassword(@RequestBody ChangePasswordRequest changePasswordRequest, Authentication connectedUser) {
		this.service.changePassword(connectedUser, changePasswordRequest);
	}

	@PostMapping("/updateProfil")
	public ResponseEntity<UserDto> updateProfile(@RequestBody UserDto userDto, Authentication connectedUser) {
		return ResponseEntity.ok(this.service.updateProfil(connectedUser, userDto));
	}

}
