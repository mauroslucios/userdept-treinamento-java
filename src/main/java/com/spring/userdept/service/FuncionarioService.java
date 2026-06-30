package com.spring.userdept.service;

import com.spring.userdept.dto.FuncionarioDTO;
import com.spring.userdept.dto.UserDTO;
import com.spring.userdept.entities.Funcionario;
import com.spring.userdept.entities.User;
import com.spring.userdept.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    public FuncionarioService(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<FuncionarioDTO> findAll(){
        List<Funcionario> list = funcionarioRepository.findAll();
        return  FuncionarioDTO.converter(list);
    }

    public FuncionarioDTO findById(Long id){
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(id));
        return new FuncionarioDTO(funcionario);
    }
    public Funcionario insertFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario updateFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public void deleteFuncionario(Long id) {
        funcionarioRepository.deleteById(id);
    }

 }
