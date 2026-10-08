package com.example.trabalho_mecanico.controller;

import com.example.trabalho_mecanico.model.conserto.*;
import com.example.trabalho_mecanico.services.GerenciarConsertoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/conserto")
public class ConsertoController {
    @Autowired
    private GerenciarConsertoService gerenciarConsertoService;
    @PostMapping
    @Transactional
    public ResponseEntity<SimpleViewConserto> cadastrarConserto(@RequestBody @Valid DadosConserto dadosConserto,
                                                                UriComponentsBuilder uriBuilder){
        SimpleViewConserto viewConserto= gerenciarConsertoService.save(dadosConserto);

        URI uri = uriBuilder.path("/conserto/{id}").buildAndExpand(viewConserto.id()).toUri();

        return ResponseEntity.created(uri).body(viewConserto);

    }

    @PutMapping
    @Transactional
    public ResponseEntity<SimpleViewConsertoAlterado> alterarConserto(@RequestBody @Valid DadosConsertoAlterar dados){
        SimpleViewConsertoAlterado consertoAlterado=gerenciarConsertoService.alterar(dados);
        return ResponseEntity.ok(consertoAlterado);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        gerenciarConsertoService.excluirComAtivoFalse(id);
        return ResponseEntity.noContent().build();

    }



    @GetMapping
    public Page<Conserto> returnAllConsertos(Pageable pageable){
        return gerenciarConsertoService.returnAllConserto(pageable);
    }

    @GetMapping("/simpleview")
    public List<SimpleViewConserto> simpleViewConsertos(){
        return gerenciarConsertoService.returnAllConsertoSimpleView();
    }

    @GetMapping("/simpleviewativo")
    public Page<SimpleViewConserto> returnAllConsertoAtivoSimpleView(@PageableDefault (size=10,sort={"id"})
                                                                     Pageable pageable){
        return gerenciarConsertoService.returnAllConsertoAtivoSimpleView(pageable);

    }

    @GetMapping("{id}") ResponseEntity<SimpleViewConserto> returnConsertoById (@PathVariable Long id){
        SimpleViewConserto viewConserto = gerenciarConsertoService.returnConsertoById(id);
        return ResponseEntity.ok(viewConserto);

    }



}
