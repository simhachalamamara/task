package com.simha.SpringSecurityProject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simha.SpringSecurityProject.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	public List<Customer> findByusername(String username);

}
