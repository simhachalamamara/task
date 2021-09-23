package com.simha.SpringSecurityProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.simha.SpringSecurityProject.dao.CustomerRepository;
import com.simha.SpringSecurityProject.model.Customer;
import com.simha.SpringSecurityProject.model.SecurityCustomer;

@Service
public class UserDetailsServices123 implements UserDetailsService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		List<Customer> customer = customerRepository.findByusername(username);
		if (customer.size() == 0) {
			throw new UsernameNotFoundException(username + " is not found in our Database");
		}
		return new SecurityCustomer(customer.get(0));
	}

}
