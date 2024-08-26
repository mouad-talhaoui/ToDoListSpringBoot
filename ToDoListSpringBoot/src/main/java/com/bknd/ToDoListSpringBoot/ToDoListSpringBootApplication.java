package com.bknd.ToDoListSpringBoot;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bknd.ToDoListSpringBoot.entiites.Role;
import com.bknd.ToDoListSpringBoot.entiites.User;
import com.bknd.ToDoListSpringBoot.repositories.RoleRepository;
import com.bknd.ToDoListSpringBoot.repositories.UserRepository;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class ToDoListSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoListSpringBootApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(RoleRepository roleRepository, UserRepository userRepository,
			PasswordEncoder passwordEncoder) {
		return args -> {
			if (roleRepository.findByName("USER").isEmpty()) {
				roleRepository.save(new Role("USER"));
			}
			if (roleRepository.findByName("ADMIN").isEmpty()) {
				roleRepository.save(new Role("ADMIN"));
			}
			if (userRepository.findByEmail("admin@admin.com").isEmpty()) {
				userRepository.save(new User(LocalDate.now(), "admin@admin.com", "firstname", "lastname",
						passwordEncoder.encode("adminadminadmin"), false, true, Arrays.asList(
								roleRepository.findByName("ADMIN").get(), roleRepository.findByName("USER").get())));
			}
		};
	}
}
