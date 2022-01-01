package com.spring.userdept.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusCheck {
	
	@GetMapping("/status")
	public String statuCheck() {
		return "Check-out";
	}

}
