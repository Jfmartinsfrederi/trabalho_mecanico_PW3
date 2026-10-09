package com.example.trabalho_mecanico.model.mecanico;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public record DadosMecanico(

        @NotBlank(message = "O nome do mecânico e obrigatório")
        String nome,

        @PositiveOrZero(message = "Os anos de experiência nao podem ser negativos")
        int anosExp)
         {
             public DadosMecanico (Mecanico mecanico){
                 this(mecanico.getNome(),
                         mecanico.getAnosExp());
             }

}
