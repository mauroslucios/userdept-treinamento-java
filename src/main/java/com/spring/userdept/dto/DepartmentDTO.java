package com.spring.userdept.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.spring.userdept.model.Department;

import lombok.Getter;

@Getter
public class DepartmentDTO {
	
	private String name;
	
	public DepartmentDTO(Department department) {
		this.name = department.getName();
	}
	
	public static List<DepartmentDTO> converter(List<Department> list) {
		return list.stream().map(DepartmentDTO::new).collect(Collectors.toList());
	}

}
