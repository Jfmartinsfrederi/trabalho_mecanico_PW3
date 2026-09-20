package com.example.trabalho_mecanico.controller;

import com.example.trabalho_mecanico.model.conserto.Conserto;
import com.example.trabalho_mecanico.model.conserto.DadosConserto;
import com.example.trabalho_mecanico.model.conserto.SimpleViewConserto;
import com.example.trabalho_mecanico.services.GerenciarConsertoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conserto")
public class ConsertoController {
    @Autowired
    private GerenciarConsertoService gerenciarMecanicosService;
    @PostMapping
    @Transactional
    public void cadastrarConserto(@RequestBody @Valid DadosConserto dadosConserto){
        gerenciarMecanicosService.save(new Conserto(dadosConserto));

    }
    @GetMapping
    public Page<Conserto> returnAllConsertos(Pageable pageable){
        return gerenciarMecanicosService.returnAllConserto(pageable);
    }

    @GetMapping("/simpleview")
    public List<SimpleViewConserto> simpleViewConsertos(){
        return gerenciarMecanicosService.returnAllConsertoSimpleView();
    }



}
