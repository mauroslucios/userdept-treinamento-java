package com.spring.userdept.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.userdept.dto.DepartmentDTO;
import com.spring.userdept.model.Department;
import com.spring.userdept.repository.DepartmentRepository;

public class DepartmentService {
	
	@Autowired
	DepartmentRepository departmentRepository;

	public List<DepartmentDTO> findAll() {
		List<Department> list = departmentRepository.findAll();
		return DepartmentDTO.converter(list);
	}

	public Department insertDepartment(Department department) {
		return departmentRepository.save(department);
	}
	
	

}
