package com.example.trabalho_mecanico.model.conserto;

import java.time.LocalDate;

public record SimpleViewConserto(
        long id,
        LocalDate dataEntrada,
                                 LocalDate dataSaida,
                                 String nomeMecanico,
                                 String marcaVeiculo,
                                 String modeloVeiculo) {
    public SimpleViewConserto(Conserto conserto){
        this(
                conserto.getId(),
                conserto.getDataEntrada(),
                conserto.getDataSaida(),
                conserto.getMecanicoResponsavel().getNome(),
                conserto.getVeiculo().getMarca(),
                conserto.getVeiculo().getModelo());
    }
}
