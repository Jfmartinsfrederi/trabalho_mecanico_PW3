package com.example.trabalho_mecanico.model.mecanico;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record DadosMecanico(
        @NotBlank
        @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$")
        String cpf,
        @NotBlank
        String nome,
        int anosExp,
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate dataEntradaOficina) {

}
