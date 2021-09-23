package com.simha.SpringSecurityProject.model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JWTGenaratorTokenValidator extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest arg0, HttpServletResponse arg1, FilterChain arg2)
			throws ServletException, IOException {
		String jwt = arg0.getHeader("Authorization");

		if (null != jwt) {
			try {
				SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.secrete_key.getBytes(StandardCharsets.UTF_8));

				Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
			} catch (Exception e) {
				System.out.println("Error is" + e.toString());
				throw new BadCredentialsException("Invalid token received");
			}
		}

		arg2.doFilter(arg0, arg1);
	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {

		return request.getServletPath().equals("/user");
	}

}
