package com.bknd.ToDoListSpringBoot.entiites;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.annotations.NaturalId;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "AppUser")
public class User implements UserDetails, Principal{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private LocalDate dateOfBirth;
	
    @Column(unique = true)
	@NaturalId
	@Email
	private String email;
	
	private String firstname;
	
	private String lastname;
	
	private String password;
	
	private boolean accountLocked;
    private boolean enabled;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Role> roles = new ArrayList<>();
	
	@OneToMany(mappedBy = "owner")
	private List<Task> tasks = new ArrayList<>();
	
	

	public User() {
		super();
	}
	
	

	public User(Long id, LocalDate dateOfBirth, @Email String email, String firstname, String lastname, String password,
			boolean accountLocked, boolean enabled, List<Role> roles, List<Task> tasks) {
		super();
		this.id = id;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.accountLocked = accountLocked;
		this.enabled = enabled;
		this.roles = roles;
		this.tasks = tasks;
	}
	
	



	public User(Long id, LocalDate dateOfBirth, @Email String email, String firstname, String lastname, String password,
			boolean accountLocked, boolean enabled, List<Role> roles) {
		super();
		this.id = id;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.accountLocked = accountLocked;
		this.enabled = enabled;
		this.roles = roles;
	}
	
	



	public User(LocalDate dateOfBirth, @Email String email, String firstname, String lastname, String password,
			boolean accountLocked, boolean enabled, List<Role> roles) {
		super();
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.accountLocked = accountLocked;
		this.enabled = enabled;
		this.roles = roles;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public boolean isAccountLocked() {
		return accountLocked;
	}

	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String getName() {
		return this.email;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return this.roles
                .stream()
                .map(r -> new SimpleGrantedAuthority(r.getName()))
                .collect(Collectors.toList());
	}

	@Override
	public String getUsername() {
		return email;
	}
	
	@Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !accountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
    
    

	
	
	
	
	
	
}
