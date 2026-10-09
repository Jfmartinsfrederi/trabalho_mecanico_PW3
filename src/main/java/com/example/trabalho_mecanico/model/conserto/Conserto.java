package com.example.trabalho_mecanico.model.conserto;

import com.example.trabalho_mecanico.model.mecanico.Mecanico;
import com.example.trabalho_mecanico.model.veiculo.Veiculo;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "Conserto")
@Table(name = "consertos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Conserto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataEntrada;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataSaida;
    private boolean ativo;
    @Embedded
    private Mecanico mecanicoResponsavel;
    @Embedded
    private Veiculo veiculo;

    public Conserto(DadosConserto dadosConserto) {
        this.dataEntrada = dadosConserto.dataEntrada();
        this.dataSaida = dadosConserto.dataSaida();
        this.ativo=true;
        this.mecanicoResponsavel = new Mecanico(dadosConserto.mecanicoResponsavel());
        this.veiculo = new Veiculo(dadosConserto.veiculo());
    }
}
