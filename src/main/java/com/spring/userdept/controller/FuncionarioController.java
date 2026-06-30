package com.spring.userdept.controller;

import com.spring.userdept.dto.FuncionarioDTO;
import com.spring.userdept.dto.UserDTO;
import com.spring.userdept.entities.Funcionario;
import com.spring.userdept.service.FuncionarioService;
import com.spring.userdept.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1")
@Tag(name="API Rest Funcionário", description = "Operações para gerenciamento de Funcionários")
@CrossOrigin(origins="*")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/funcionarios")
    @Operation(summary ="Retorna uma lista de funcionarios")
    public ResponseEntity<List<FuncionarioDTO>> findAll(){
        List<FuncionarioDTO> list = funcionarioService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/funcionario")
    @Operation(summary = "Cadastra um novo funcionário")
    public ResponseEntity<FuncionarioDTO> cadastrarFuncionario(@Valid @RequestBody(required = true) FuncionarioDTO dto){
        Funcionario funcionarioEntidade =  dto.toEntity();
        Funcionario salvarFuncionario = funcionarioService.insertFuncionario(funcionarioEntidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(new FuncionarioDTO(salvarFuncionario));
    }

}
