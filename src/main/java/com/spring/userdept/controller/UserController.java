package com.spring.userdept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.userdept.dto.UserDTO;
import com.spring.userdept.model.User;
import com.spring.userdept.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API Rest User")
@CrossOrigin(origins="*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	@ApiOperation(value="Retorna uma lista de usuários")
	public ResponseEntity<List<UserDTO>> findAll(){
		List<UserDTO> list = userService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/users/{id}")
	@ApiOperation(value="Retorna apenas um usuário")
	public User findOne(@PathVariable(value="id") Long id){
		User result = userService.findById(id);
		return result;
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/user")
	@ApiOperation(value="Salva um produto no banco")
	public User insertUser(@RequestBody User user) {
		return userService.insertUser(user);
	}
	
	
	
	
	
}
