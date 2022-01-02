package com.spring.userdept.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.userdept.dto.UserDTO;
import com.spring.userdept.model.User;
import com.spring.userdept.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public List<UserDTO> findAll() {
		List<User> list = userRepository.findAll();
		return UserDTO.converter(list);
	}

	public User findById(Long id) {
		return userRepository.findById(id).get();
	}

	public User insertUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(User user) {
		return userRepository.save(user);
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
}
