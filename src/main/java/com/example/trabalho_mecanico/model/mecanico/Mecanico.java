package com.example.trabalho_mecanico.model.mecanico;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;


@Table(name = "mecanicos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable

public class Mecanico {



    private String nome;
    private int anosExp;





    public Mecanico (DadosMecanico dadosMecanico){

        this.nome = dadosMecanico.nome();
        this.anosExp = dadosMecanico.anosExp();

    }


}
