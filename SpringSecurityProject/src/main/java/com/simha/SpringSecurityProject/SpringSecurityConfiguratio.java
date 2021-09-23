package com.simha.SpringSecurityProject;

import java.util.Arrays;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import com.simha.SpringSecurityProject.model.AuthorityLoggingAfterFilter;
import com.simha.SpringSecurityProject.model.JWTGenaratorTokenValidator;
import com.simha.SpringSecurityProject.model.JWTTokenGeneration;
import com.simha.SpringSecurityProject.model.RequestValidationFilter;

@Configuration
public class SpringSecurityConfiguratio extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().
		cors().configurationSource(new CorsConfigurationSource() {

			@Override
			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				CorsConfiguration corsconfig = new CorsConfiguration();
				corsconfig.setAllowedHeaders(Collections.singletonList("*"));
				corsconfig.setMaxAge(3600l);
				corsconfig.setAllowCredentials(true);
				corsconfig.setExposedHeaders(Arrays.asList("Authorization"));
				corsconfig.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
				corsconfig.setAllowedMethods(Collections.singletonList("*"));

				return corsconfig;
			}
		})./*and().csrf().ignoringAntMatchers("/contact").csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and().authorizeRequests().antMatchers("/account").authenticated().antMatchers("/balance").authenticated()
				.antMatchers("/cards").hasAnyAuthority("Write").antMatchers("/balance").authenticated().antMatchers("/notices")
			
				.permitAll().antMatchers("/contact").permitAll().and().formLogin().and().httpBasic().and().addFilterBefore(new RequestValidationFilter(), BasicAuthenticationFilter.class).addFilterAfter(new AuthorityLoggingAfterFilter(), BasicAuthenticationFilter.class);
*/
		and().csrf().disable().authorizeRequests().antMatchers("/user").authenticated().antMatchers("/balance").authenticated()
		.antMatchers("/cards").hasAnyAuthority("Write").antMatchers("/balance").authenticated().antMatchers("/notices")
		.permitAll().antMatchers("/contact").permitAll().and().formLogin().and().httpBasic().and().
		addFilterBefore(new RequestValidationFilter(), BasicAuthenticationFilter.class).
		addFilterBefore(new JWTGenaratorTokenValidator(), BasicAuthenticationFilter.class).
		addFilterAfter(new JWTTokenGeneration(), BasicAuthenticationFilter.class).
		addFilterAfter(new AuthorityLoggingAfterFilter(), BasicAuthenticationFilter.class);

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
