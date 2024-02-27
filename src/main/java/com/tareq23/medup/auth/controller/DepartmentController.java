package com.tareq23.medup.auth.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	@GetMapping
	public Object departmentList()
	{
		return List.of("CSE","IT","TEXTILE","PHYSICS","CHEMISTRY");
	}
	
}
