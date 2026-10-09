package com.example.trabalho_mecanico.model.veiculo;

import com.example.trabalho_mecanico.model.conserto.DadosConsertoAlterar;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record DadosVeiculo(
        @NotBlank(message = "A marca do veiculo e obrigatória")
        String marca,

        @NotBlank(message = "O modelo do veiculo e obrigatório")
        String modelo,

        String cor,

        @NotBlank(message = "O ano e obrigatório")
        @Pattern(regexp = "\\d{4}", message = "O ano deve ter quatro dígitos (xxxx)")
        String anoLancamento) {
        public DadosVeiculo (Veiculo veiculo){
                this(veiculo.getMarca(),
                        veiculo.getModelo(),
                        veiculo.getCor(),
                        veiculo.getAnoLancamento());
        }
}
