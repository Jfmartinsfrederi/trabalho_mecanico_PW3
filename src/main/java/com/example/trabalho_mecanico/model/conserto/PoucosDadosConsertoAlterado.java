package com.example.trabalho_mecanico.model.conserto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record PoucosDadosConsertoAlterado(

        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataSaida,
                                 String nomeMecanico,
                                 int anosExp) {
    public PoucosDadosConsertoAlterado(Conserto conserto){
        this(

                conserto.getDataSaida(),
                conserto.getMecanicoResponsavel().getNome(),
                conserto.getMecanicoResponsavel().getAnosExp());
    }
}
