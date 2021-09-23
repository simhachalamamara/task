package com.simha.SpringSecurityProject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@RequestMapping("/welcome")
	public String sayWelcome()
	{
		return "Hi Welcome to my World";
	}
	@RequestMapping("/user")
	public String say()
	{
		return "hello user";
	}

}
