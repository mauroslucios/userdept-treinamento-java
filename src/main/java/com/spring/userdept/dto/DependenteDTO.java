package com.spring.userdept.dto;

import com.spring.userdept.entities.Dependente;
import com.spring.userdept.entities.Funcionario;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Objeto de transferência de dados para criação de dependente")
public class DependenteDTO extends PessoaDTO {

    @Schema(description = "Grau de parentesco", example= "Filho(a)")
    @NotBlank(message = "O parentesco é obrigatório")
    private String parentesco; // Ex: Filho, Cônjuge


    @Schema(description = "Id do funcionário responsável", example="1")
    @NotNull(message = "O Id do funcionário responsável é obrigatório")
    private Funcionario responsavel;

   // Método reverso: DTO -> Entidade
    public Dependente toEntity(Funcionario responsavel) {
        Dependente dep = new Dependente();
        dep.setId(this.getId());
        dep.setName(this.getName());
        dep.setEmail(this.getEmail());
        dep.setParentesco(this.getParentesco());
        dep.setResponsavel(responsavel);
        return dep;
    }


}
