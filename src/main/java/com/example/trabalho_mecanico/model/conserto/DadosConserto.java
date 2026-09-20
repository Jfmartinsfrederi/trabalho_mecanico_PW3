package com.example.trabalho_mecanico.model.conserto;

import com.example.trabalho_mecanico.model.mecanico.DadosMecanico;

import com.example.trabalho_mecanico.model.veiculo.DadosVeiculo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;


import java.time.LocalDate;

public record DadosConserto(

        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate dataEntrada,

        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate dataSaida,
        @Valid
        DadosMecanico mecanicoResponsavel,
        @Valid
        DadosVeiculo veiculo) {
}
