package com.example.trabalho_mecanico.services;

import com.example.trabalho_mecanico.model.conserto.*;
import com.example.trabalho_mecanico.repository.ConsertoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GerenciarConsertoService {
    @Autowired
    private ConsertoRepository consertoRepository;

    @Transactional
    public PoucosDadosConserto save(DadosConserto dadosConserto){
        if (dadosConserto.dataSaida().isBefore(dadosConserto.dataEntrada())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "A data de saída nao pode ser anterior a de entrada"
            );
        }

        Conserto conserto=consertoRepository.save(new Conserto(dadosConserto));

        return new PoucosDadosConserto(conserto);
    }

    @Transactional
    public PoucosDadosConsertoAlterado alterar(Long id, DadosConsertoAlterar dadosAlterar){
        Conserto conserto=consertoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Conserto não encontrado"));


        if (dadosAlterar.nome() != null) {
            if (dadosAlterar.nome().isBlank()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O nome nao pode ficar em branco");
            }
            conserto.getMecanicoResponsavel().setNome(dadosAlterar.nome());
        }

        if (dadosAlterar.anosExp() != null) {
            if (dadosAlterar.anosExp() < 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Anos de experiencia não podem ser negativos");
            }
            conserto.getMecanicoResponsavel().setAnosExp(dadosAlterar.anosExp());
        }

        if (dadosAlterar.dataSaida() != null) {
            if (dadosAlterar.dataSaida().isBefore(conserto.getDataEntrada())) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "A data de saída nao pode ser anterior a de entrada"
                );
            }
            conserto.setDataSaida(dadosAlterar.dataSaida());
        }

        return new PoucosDadosConsertoAlterado(conserto);
    }

    @Transactional
    public void excluirComAtivoFalse(Long id){
        Conserto conserto=consertoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Conserto não encontrado"));
        conserto.setAtivo(false);
    }

    @Transactional(readOnly = true)
    public Page<DadosConserto> returnAllConserto(Pageable pageable){
        return consertoRepository.findAll(pageable).map(DadosConserto::new);
    }
    @Transactional(readOnly = true)
    public List<PoucosDadosConserto> returnAllConsertoPoucosDados(){
        return consertoRepository.findAll().stream().map(PoucosDadosConserto::new).toList();
    }
    @Transactional(readOnly = true)
    public Page<PoucosDadosConserto> returnAllConsertoAtivoPoucosDados(Pageable pageable){
        return consertoRepository.findAllByAtivoTrue(pageable).map(PoucosDadosConserto::new);
    }
    @Transactional(readOnly = true)
    public PoucosDadosConserto returnConsertoById(Long id){
        Conserto conserto=consertoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Conserto não encontrado"));

        return new PoucosDadosConserto(conserto);
    }

}
