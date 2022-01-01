package com.spring.userdept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.userdept.dto.DepartmentDTO;
import com.spring.userdept.model.Department;
import com.spring.userdept.service.DepartmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API Rest User/Department")
@CrossOrigin(origins="*")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/department")
	@ApiOperation(value="Retorna uma lista de departamentos")
	public List<DepartmentDTO> listAll(){
		return departmentService.findAll();
	}

	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value="Salva um deparatamento no banco")
	@PostMapping("/department")
	public Department insertDepartment(@RequestBody Department department) {
		return departmentService.insertDepartment(department);
	}
}
