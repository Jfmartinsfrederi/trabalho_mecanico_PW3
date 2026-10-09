package com.example.trabalho_mecanico.model.conserto;

import com.example.trabalho_mecanico.model.mecanico.DadosMecanico;
import com.example.trabalho_mecanico.model.veiculo.DadosVeiculo;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public record DadosConsertoAlterar(

        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataSaida,

        @Pattern(regexp = ".*\\S.*", message = "O nome nao pode estar em branco")
        String nome,

        @PositiveOrZero(message = "Os anos de experiência nao podem ser negativos")
        Integer anosExp) {
}
