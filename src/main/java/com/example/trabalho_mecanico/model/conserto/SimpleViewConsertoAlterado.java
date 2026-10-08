package com.example.trabalho_mecanico.model.conserto;

import java.time.LocalDate;

public record SimpleViewConsertoAlterado(

                                 LocalDate dataSaida,
                                 String nomeMecanico,
                                 int anosExp) {
    public SimpleViewConsertoAlterado(Conserto conserto){
        this(

                conserto.getDataSaida(),
                conserto.getMecanicoResponsavel().getNome(),
                conserto.getMecanicoResponsavel().getAnosExp());
    }
}
