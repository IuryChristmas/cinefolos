package br.com.cinefolos.cine.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name="users")
public class User {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String email;
	
	@NotNull
	private String password;
	
	public User() {}

	public User(String email, String name, String password) {
		this.email = email; 
		this.name = name;
		this.password = new BCryptPasswordEncoder().encode(password);
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
