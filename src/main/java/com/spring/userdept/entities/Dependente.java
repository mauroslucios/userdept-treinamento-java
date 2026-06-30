package com.spring.userdept.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "tb_dependente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dependente extends Pessoa {

    private String parentesco; // Ex: Filho, Cônjuge


    @ManyToOne
    @JoinColumn(name = "responsavel_id")
    private Funcionario responsavel;

    public String obterPapel(){
        return "Dependente do(a) Funcionario(a): " + responsavel.getName();
    }
}
