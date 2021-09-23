package com.simha.SpringSecurityProject.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.simha.SpringSecurityProject.dao.CustomerRepository;

@Component
public class SimpleAuthenticationProvider  implements org.springframework.security.authentication.AuthenticationProvider{

	@Autowired
	private CustomerRepository customeRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username=authentication.getName();
		 String password = (String)authentication.getCredentials();
		 UsernamePasswordAuthenticationToken upat=null;
		 List<Customer> customer=customeRepository.findByusername(username);
		 
		 if(customer.size()!=0)
		 {
		 if(passwordEncoder.matches(password, customer.get(0).getPassword()))
		 {
			
			 Set<Authority> authorities = customer.get(0).getAuthorities();
				
			 List<GrantedAuthority> al=new ArrayList<>();
				for(Authority auth:authorities)
				{
					
					
					al.add(new SimpleGrantedAuthority(auth.getName()));
					
				}
			 
	
			
		    upat=new UsernamePasswordAuthenticationToken(username,password,al);
		 }
		 else
		 {
			 throw new BadCredentialsException(username+ " is not found in our database");
		 }
	}
		 else
		 {
			 throw new BadCredentialsException("User name is not found in our database");
		 }
		 
		return upat;
	}
	
	public void getAuthorities(List<Customer> customer)
	{
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	
	
	
}
