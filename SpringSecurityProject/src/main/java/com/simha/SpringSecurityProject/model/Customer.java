package com.simha.SpringSecurityProject.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="customers")
public class Customer  {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="customer_id")
	private int id;
	private String username;
	private String password;
	private String emailId;
	private String role;
	private int enabled;
	
	@JsonIgnore
	@OneToMany(mappedBy="customer",fetch=FetchType.EAGER)
	
	private Set<Authority> authorities;
	
	public Set<Authority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getEmailId() {
		return emailId;
	}
	public String getRole() {
		return role;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
}
