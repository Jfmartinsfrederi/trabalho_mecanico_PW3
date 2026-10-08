package com.example.trabalho_mecanico.model.mecanico;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record DadosMecanico(
        @NotBlank
        @NotBlank
        String nome,
        int anosExp)
         {

}
