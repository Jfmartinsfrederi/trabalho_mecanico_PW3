package com.example.trabalho_mecanico.model.veiculo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Table(name = "veiculos")
@AllArgsConstructor
@NoArgsConstructor
@Getter

@Embeddable
public class Veiculo {


    private String marca;
    private String modelo;
    private String cor;
    private String anoLancamento;

    public Veiculo(DadosVeiculo dadosVeiculo) {
        this.marca = dadosVeiculo.marca();
        this.modelo = dadosVeiculo.modelo();
        this.cor=dadosVeiculo.cor();
        this.anoLancamento = dadosVeiculo.anoLancamento();
    }
}
