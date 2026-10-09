package com.example.trabalho_mecanico.model.conserto;

import com.example.trabalho_mecanico.model.mecanico.DadosMecanico;

import com.example.trabalho_mecanico.model.veiculo.DadosVeiculo;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDate;

public record DadosConserto(

        @NotNull(message = "A data de entrada e obrigatória")
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataEntrada,

        @NotNull(message = "A data de saída e obrigatória")
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataSaida,

        @NotNull(message = "O mecânico e obrigatório")
        @Valid
        DadosMecanico mecanicoResponsavel,

        @NotNull(message = "O veiculo e obrigatório")
        @Valid
        DadosVeiculo veiculo) {
        public DadosConserto (Conserto conserto){
                this(conserto.getDataEntrada(),
                        conserto.getDataSaida(),
                        new DadosMecanico(conserto.getMecanicoResponsavel()),
                        new DadosVeiculo(conserto.getVeiculo()));
        }
}
