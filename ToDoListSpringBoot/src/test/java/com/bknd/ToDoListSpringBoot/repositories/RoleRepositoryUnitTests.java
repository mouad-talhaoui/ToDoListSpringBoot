package com.bknd.ToDoListSpringBoot.repositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import com.bknd.ToDoListSpringBoot.entiites.Role;

@DataJpaTest
public class RoleRepositoryUnitTests {
	@Autowired
	private RoleRepository roleRepository;

	@AfterEach
	void tearDown() {
		roleRepository.deleteAll();
	}

	@Test
	public void findByNameTest() {

		// Given
		Role role = new Role("Super_user");
		roleRepository.save(role);

		// when
		Role role2 = roleRepository.findByName("Super_user").get();
		// then
		assertThat(role2).isNotNull();
	}

}
