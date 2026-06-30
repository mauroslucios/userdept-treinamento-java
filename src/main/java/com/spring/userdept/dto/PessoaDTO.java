package com.spring.userdept.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description ="Objeto base de transferência de dados para uma pessoa")
public class PessoaDTO {

    private Long id;

    @Schema(description = "Nome completo", example = "João Silva")
    @NotBlank(message = "O nome é obrigatório")
    private String name;

    @Schema(description = "E-mail válido", example = "joao.silva@empresa.com")
    @Email(message = "Insira um e-mail válido")
    @NotBlank(message = "O e-mail é obrigatório")
    private String email;
}
