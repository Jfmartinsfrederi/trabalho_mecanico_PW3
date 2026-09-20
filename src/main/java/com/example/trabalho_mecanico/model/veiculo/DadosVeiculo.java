package com.example.trabalho_mecanico.model.veiculo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record DadosVeiculo(
        @NotBlank
        String marca,
        @NotBlank
        String modelo,
        String cor,

        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate anoLancamento) {
}
