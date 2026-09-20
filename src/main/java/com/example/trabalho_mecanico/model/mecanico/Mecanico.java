package com.example.trabalho_mecanico.model.mecanico;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;


@Table(name = "mecanicos")
@AllArgsConstructor
@NoArgsConstructor
@Getter

@Embeddable

public class Mecanico {


    private String cpf;
    private String nome;
    private int anosExp;
    private LocalDate dataEntradaOficina;


    public int getAnosExp() {
        return Period.between(dataEntradaOficina,LocalDate.now()).getYears();
    }

    public Mecanico (DadosMecanico dadosMecanico){
        this.cpf = dadosMecanico.cpf();
        this.nome = dadosMecanico.nome();
        this.anosExp = dadosMecanico.anosExp();
        this.dataEntradaOficina = dadosMecanico.dataEntradaOficina();
    }


}
