package com.example.trabalho_mecanico.model.veiculo;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;


@Table(name = "veiculos")
@AllArgsConstructor
@NoArgsConstructor
@Getter

@Embeddable
public class Veiculo {


    private String marca;
    private String modelo;
    private String cor;
    private LocalDate anoLancamento;

    public Veiculo(DadosVeiculo dadosVeiculo) {
        this.marca = dadosVeiculo.marca();
        this.modelo = dadosVeiculo.modelo();
        this.anoLancamento = dadosVeiculo.anoLancamento();
    }
}
