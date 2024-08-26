package com.bknd.ToDoListSpringBoot.Security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bknd.ToDoListSpringBoot.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private final UserRepository repository;

	public UserDetailsServiceImpl(UserRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
	}
}
