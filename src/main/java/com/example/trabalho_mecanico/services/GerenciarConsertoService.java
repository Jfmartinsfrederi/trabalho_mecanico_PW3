package com.example.trabalho_mecanico.services;

import com.example.trabalho_mecanico.model.conserto.Conserto;
import com.example.trabalho_mecanico.model.conserto.SimpleViewConserto;
import com.example.trabalho_mecanico.repository.ConsertoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GerenciarConsertoService {
    @Autowired
    private ConsertoRepository consertoRepository;

    public void save(Conserto conserto){
        consertoRepository.save(conserto);
    }

    public Page<Conserto> returnAllConserto(Pageable pageable){
        return consertoRepository.findAll(pageable);
    }

    public List<SimpleViewConserto> returnAllConsertoSimpleView(){
        return consertoRepository.findAll().stream().map(SimpleViewConserto::new).toList();
    }

}
