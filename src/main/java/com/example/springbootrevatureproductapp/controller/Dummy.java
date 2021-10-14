package com.example.springbootrevatureproductapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dummy")
public class Dummy {
	
	@GetMapping()
	public String getMessage() {
		return "This is the dummy page";
	}
	

}
