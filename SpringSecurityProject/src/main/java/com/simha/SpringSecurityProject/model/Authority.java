package com.simha.SpringSecurityProject.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="authoritiesyes")
public class Authority implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	private String name;
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
