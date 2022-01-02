package com.spring.userdept.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.userdept.dto.DepartmentDTO;
import com.spring.userdept.model.Department;
import com.spring.userdept.repository.DepartmentRepository;

@Service
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

	public Department findById(Long id) {
		return departmentRepository.findById(id).get();
	}

	public Department updateDepartment(Department department) {
		return departmentRepository.save(department);
	}

	public void deleteDepartment(Long id) {
		departmentRepository.deleteById(id);
	}
	
	

}
