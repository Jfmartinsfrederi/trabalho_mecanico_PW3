package com.example.trabalho_mecanico.model.conserto;

import com.example.trabalho_mecanico.model.mecanico.DadosMecanico;
import com.example.trabalho_mecanico.model.veiculo.DadosVeiculo;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosConsertoAlterar(

        @NotNull
        Long id,
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate dataSaida,

        String nome,

        int anosExp) {
}
