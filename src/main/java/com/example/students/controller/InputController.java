package com.example.students.controller;


import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class InputController {
	
	
	
	 
	@GetMapping
	public String haiHello()
	{
		return "Hello welcome to vivekanandan.you can create a new Student by making a POST request to /api/students endpoint.";
	}

}
