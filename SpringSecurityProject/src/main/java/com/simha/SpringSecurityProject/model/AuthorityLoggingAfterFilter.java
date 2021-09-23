package com.simha.SpringSecurityProject.model;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.jboss.logging.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthorityLoggingAfterFilter implements Filter {
	Logger authfiletr=Logger.getLogger(AuthorityLoggingAfterFilter.class);

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
		
		
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(authentication!=null)
		{
			
			authfiletr.info("user "+authentication.getName() +" is successfully logged with autherotities are "+ authentication.getAuthorities().toString());
		}
		// TODO Auto-generated method stub
		arg2.doFilter(arg0, arg1);
	}

}
