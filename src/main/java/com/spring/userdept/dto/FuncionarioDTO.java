package com.spring.userdept.dto;

import com.spring.userdept.entities.Funcionario;
import com.spring.userdept.entities.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Objeto de transferência de dados para criação de funcionário")
public class FuncionarioDTO extends PessoaDTO {

    @Schema(description = "Cargo atual do funcionário", example = "Desenvolvedor Backend")
    @NotBlank(message = "O cargo é obrigatório")
    private String cargo;

    @Schema(description = "Salário bruto mensal", example = "5500.00")
    @NotNull(message = "O salário é obrigatório")
    @Positive(message = "O salário deve ser maior que zero")
    private BigDecimal salario;

    public FuncionarioDTO(Funcionario funcionario) {
        super(funcionario.getId(), funcionario.getName(), funcionario.getEmail());
        this.cargo = funcionario.getCargo();
        this.salario = funcionario.getSalario();
    }

    public static List<FuncionarioDTO> converter(List<Funcionario> list) {
        return list.stream().map(FuncionarioDTO::new).collect(Collectors.toList());
    }

    public Funcionario toEntity() {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(this.getId());
        funcionario.setName(this.getName());
        funcionario.setEmail(this.getEmail());
        funcionario.setCargo(this.getCargo());
        funcionario.setSalario(this.getSalario());
        return funcionario;
    }
}
