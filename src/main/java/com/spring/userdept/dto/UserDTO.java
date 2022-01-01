package com.spring.userdept.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.spring.userdept.model.Department;
import com.spring.userdept.model.User;

import lombok.Getter;

@Getter
public class UserDTO {

	private Long id;
	private String name;
	private String email;
	private Department department;
	
	public UserDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.department = user.getDepartment();
	}
	
	public static List<UserDTO> converter(List<User> list) {
		return list.stream().map(UserDTO::new).collect(Collectors.toList());
	}
}
