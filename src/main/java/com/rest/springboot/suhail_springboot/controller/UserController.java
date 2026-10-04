package com.rest.springboot.suhail_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	
	@GetMapping
	public String welcome() {
		System.out.println("Hello method");
		return "home";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
