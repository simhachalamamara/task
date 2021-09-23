package com.simha.SpringSecurityProject.model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JWTTokenGeneration extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest arg0, HttpServletResponse arg1, FilterChain arg2)
			throws ServletException, IOException {
		
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(authentication!=null)
		{
			 SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.secrete_key.getBytes(StandardCharsets.UTF_8));
			
			String jwt=Jwts.builder().setIssuer("Eazy Bank").setSubject("JWT Token").claim("userName", authentication.getName()).
					claim("authority", authentication.getAuthorities().toString()).setIssuedAt(new Date()).setExpiration((new Date(new Date().getTime()+300000)))
					.signWith(key).compact();
			
			System.out.println("hello");
			arg1.setHeader("Authorization", jwt);
			
			
		}
		
		
		
		
		arg2.doFilter(arg0, arg1);
		
	}
	
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		
		return  !request.getServletPath().equals("/user");
	}
	
	

}
