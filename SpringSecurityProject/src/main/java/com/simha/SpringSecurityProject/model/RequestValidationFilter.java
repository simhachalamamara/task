package com.simha.SpringSecurityProject.model;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Base64.Decoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;

public class RequestValidationFilter implements Filter{

	private static  String Authorization;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter)
			throws IOException, ServletException {
		
		HttpServletRequest	Httprequest=(HttpServletRequest) request;
		HttpServletResponse	Httpresponse=(HttpServletResponse) response;
		
		String authorization=Httprequest.getHeader("Authorization");
		String usernamAndPasswordaray[]=authorization.split(" ");
		
	
		String usernamAndPassword=usernamAndPasswordaray[1];
		
		System.out.println(usernamAndPassword);
		
		Decoder decoder = Base64.getDecoder();
		byte[] value = decoder.decode(usernamAndPassword);
		
		String s=new String(value);
		
		String users[]=s.split(":");
		
		if(users[0].contains("test"))
		{
			
			throw new BadCredentialsException("invalid credentionals provided by username and password contain test");
		}
				
      
		System.out.println(authorization);
		
		filter.doFilter(request, response);
	}

	
	

}
