package com.spring.userdept.dto;

import java.util.List;
import java.util.stream.Collectors;
import com.spring.userdept.enums.Departments;
import com.spring.userdept.entities.User; // Ajuste o pacote conforme seu projeto
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Schema(description = "Objeto de transferência de dados para criação de usuário")
public class UserDTO extends PessoaDTO {

	@Schema(description = "Departamento ao qual o usuário pertence", example = "RECURSOS_HUMANOS")
	@NotNull(message = "O departamento é obrigatório") // Corrigido para Enums
	private Departments department;

	public UserDTO(User user) {
		// Passa os dados comuns para o construtor da classe mãe (PessoaDTO)
		super(user.getId(), user.getName(), user.getEmail());
		this.department = user.getDepartment();
	}

	public static List<UserDTO> converter(List<User> list) {
		return list.stream().map(UserDTO::new).collect(Collectors.toList());
	}

	public User toEntity() {
		User user = new User();
		user.setId(this.getId());
		user.setName(this.getName());   // Certifique-se de que não está vazio
		user.setEmail(this.getEmail());  // Certifique-se de que não está vazio
		user.setDepartment(this.getDepartment());
		return user;
	}
}
