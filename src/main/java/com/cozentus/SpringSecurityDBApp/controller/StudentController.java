package com.cozentus.SpringSecurityDBApp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	

	@GetMapping("/user")
	@PreAuthorize("hasRole('USER')")
	public String about() {
		return "user";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String profile() {
		return "admin";
	}


	

}
