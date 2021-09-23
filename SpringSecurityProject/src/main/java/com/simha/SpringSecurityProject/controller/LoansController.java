package com.simha.SpringSecurityProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {
	@RequestMapping("/loans")
	public String getNotices()
	{
		return "welcome to my loans";
	}
}
