package com.spring.userdept.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.userdept.dto.UserDTO;
import com.spring.userdept.entities.User;
import com.spring.userdept.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value="/api/v1")
@Tag(name="API Rest User", description = "Operações para gerenciamento de Usuários")
@CrossOrigin(origins="*")
public class UserController {

	private final UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/users")
	@Operation(summary ="Retorna uma lista de usuários")
	public ResponseEntity<List<UserDTO>> findAll(){
		List<UserDTO> list = userService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/users/{id}")
	@Operation(summary ="Retorna apenas um usuário")
	public ResponseEntity<UserDTO> findOne(@PathVariable Long id){
        UserDTO dto = userService.findById(id);
		return ResponseEntity.ok().body(dto);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/users")
	@Operation(summary ="Salva um usuário validado no banco")
	// Adicionamos explicitamente (required = true) para forçar o Spring a ignorar o Swagger e focar no JSON
	public ResponseEntity<UserDTO> cadastrarUsuario(@Valid @RequestBody(required = true) UserDTO dto){
		User userEntidade = dto.toEntity();
		User salvarEntidade = userService.insertUser(userEntidade);
		return ResponseEntity.status(HttpStatus.CREATED).body(new UserDTO(salvarEntidade));
	}



	@Operation(summary ="Atualiza um usuário pelo id") // Corrigido de "produto" para "usuário"
	@PutMapping("/users/{id}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable(value = "id") Long id, @Valid @RequestBody UserDTO dto) {
		User userEntidade = dto.toEntity();
		userEntidade.setId(id);
		User atualizado = userService.updateUser(userEntidade);
		return ResponseEntity.ok().body(new UserDTO(atualizado));
	}

	@DeleteMapping("/users/{id}")
	@Operation(summary ="Deleta um usuário pelo id") // Corrigido de "produto" para "usuário"
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}

}
