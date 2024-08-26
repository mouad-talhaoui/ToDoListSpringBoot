package com.bknd.ToDoListSpringBoot.entiites;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Task extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String description;

	@Enumerated(EnumType.STRING)
	private State state;

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private User owner;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Task(String description, State state) {
		super();
		this.description = description;
		this.state = state;
	}

	public Task(Long id, String description, State state) {
		super();
		this.id = id;
		this.description = description;
		this.state = state;
	}

	public Task(Long id, String description, State state, User owner) {
		super();
		this.id = id;
		this.description = description;
		this.state = state;
		this.owner = owner;
	}

	public Task(String description, State state, User owner) {
		super();
		this.description = description;
		this.state = state;
		this.owner = owner;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Task() {
		super();
	}

}
