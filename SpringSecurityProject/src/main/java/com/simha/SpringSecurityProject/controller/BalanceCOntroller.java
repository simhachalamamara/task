package com.simha.SpringSecurityProject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceCOntroller {
	@RequestMapping("/balance")
	public String getNotices()
	{
		return "welcome to my Balance";
	}
}
