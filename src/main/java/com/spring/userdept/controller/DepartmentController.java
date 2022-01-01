package com.spring.userdept.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.userdept.service.DepartmentService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="/api")
@Api(value="API Rest User/Department")
@CrossOrigin(origins="*")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	

}
