package com.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebAppController {
	
	@GetMapping("/")
	public String showHome() {
		
		return "home";
	}

	@GetMapping("/managers")
	public String showManagers() {
		
		return "managers";

	}
	
	@GetMapping("/administrators")
	public String showAdministrators() {
		
		return "administrators";

	}
	
}
