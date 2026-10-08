package com.example.trabalho_mecanico.services;

import com.example.trabalho_mecanico.model.conserto.*;
import com.example.trabalho_mecanico.repository.ConsertoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GerenciarConsertoService {
    @Autowired
    private ConsertoRepository consertoRepository;

    public SimpleViewConserto save(DadosConserto dadosConserto){

        Conserto conserto=consertoRepository.save(new Conserto(dadosConserto));

        return new SimpleViewConserto(conserto);
    }

    public SimpleViewConsertoAlterado alterar(DadosConsertoAlterar dadosAlterar){
        Conserto conserto=consertoRepository.findById(dadosAlterar.id())
                .orElseThrow(()-> new NoSuchElementException("Conserto não Encontrado"));
        if (!(dadosAlterar.nome().isBlank())){
            conserto.getMecanicoResponsavel().setNome(dadosAlterar.nome());
        }
        if (dadosAlterar.anosExp()>0){
            conserto.getMecanicoResponsavel().setAnosExp(dadosAlterar.anosExp());
        }
        if (!dadosAlterar.dataSaida().isBefore(conserto.getDataEntrada())) {
            conserto.setDataSaida(dadosAlterar.dataSaida());
        }

        return new SimpleViewConsertoAlterado(conserto);
    }

    public void excluirComAtivoFalse(Long id){
        Conserto conserto=consertoRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("Conserto não Encontrado"));
        conserto.setAtivo(false);
    }

    public Page<Conserto> returnAllConserto(Pageable pageable){
        return consertoRepository.findAll(pageable);
    }

    public List<SimpleViewConserto> returnAllConsertoSimpleView(){
        return consertoRepository.findAll().stream().map(SimpleViewConserto::new).toList();
    }

    public Page<SimpleViewConserto> returnAllConsertoAtivoSimpleView(Pageable pageable){
        return consertoRepository.findAllByAtivoTrue(pageable).map(SimpleViewConserto::new);
    }

    public SimpleViewConserto returnConsertoById(Long id){
        Conserto conserto=consertoRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("Conserto não Encontrado"));

        return new SimpleViewConserto(conserto);
    }

}
