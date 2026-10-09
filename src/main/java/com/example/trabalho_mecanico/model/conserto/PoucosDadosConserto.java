package com.example.trabalho_mecanico.model.conserto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record PoucosDadosConserto(
        long id,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataEntrada,
        @JsonFormat(pattern = "dd/MM/yyyy")
                                 LocalDate dataSaida,
                                 String nomeMecanico,
                                 String marcaVeiculo,
                                 String modeloVeiculo) {
    public PoucosDadosConserto(Conserto conserto){
        this(
                conserto.getId(),
                conserto.getDataEntrada(),
                conserto.getDataSaida(),
                conserto.getMecanicoResponsavel().getNome(),
                conserto.getVeiculo().getMarca(),
                conserto.getVeiculo().getModelo());
    }
}
