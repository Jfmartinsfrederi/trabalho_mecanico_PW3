package com.example.trabalho_mecanico.model.conserto;

import com.example.trabalho_mecanico.model.mecanico.Mecanico;
import com.example.trabalho_mecanico.model.veiculo.Veiculo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "Conserto")
@Table(name = "consertos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Conserto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    @Embedded
    private Mecanico mecanicoResponsavel;
    @Embedded
    private Veiculo veiculo;

    public Conserto(DadosConserto dadosConserto) {
        this.dataEntrada = dadosConserto.dataEntrada();
        this.dataSaida = dadosConserto.dataSaida();
        this.mecanicoResponsavel = new Mecanico(dadosConserto.mecanicoResponsavel());
        this.veiculo = new Veiculo(dadosConserto.veiculo());
    }
}
