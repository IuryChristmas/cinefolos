package br.com.cinefolos.cine.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="users")
public class User {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String email;
	
	public User() {}

	public User(String email, String name) {
		this.email = email; 
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}