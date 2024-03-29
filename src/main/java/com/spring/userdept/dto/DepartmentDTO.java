package com.spring.userdept.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.spring.userdept.model.Department;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentDTO {
	
	private Long id;
	private String name;
	
	public DepartmentDTO(Department department) {
		this.id = department.getId();
		this.name = department.getName();
	}
	
	public static List<DepartmentDTO> converter(List<Department> list) {
		return list.stream().map(DepartmentDTO::new).collect(Collectors.toList());
	}

}
