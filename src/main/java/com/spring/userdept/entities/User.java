package com.spring.userdept.entities;

import com.spring.userdept.enums.Departments;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tb_user")
public class User  extends Pessoa{

	@Enumerated(EnumType.STRING)
	private Departments department;

	@Override
	public String obterPapel(){
		return "Usuario do sistema do Departamento: " + department;
	}
	
}
