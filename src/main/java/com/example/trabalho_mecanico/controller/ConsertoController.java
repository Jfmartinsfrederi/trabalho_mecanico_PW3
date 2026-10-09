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
    public ResponseEntity<PoucosDadosConserto> cadastrarConserto(@RequestBody @Valid DadosConserto dadosConserto,
                                                                 UriComponentsBuilder uriBuilder){
        PoucosDadosConserto viewConserto= gerenciarConsertoService.save(dadosConserto);

        URI uri = uriBuilder.path("/conserto/{id}").buildAndExpand(viewConserto.id()).toUri();

        return ResponseEntity.created(uri).body(viewConserto);

    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PoucosDadosConsertoAlterado> alterarConserto(@PathVariable Long id, @RequestBody @Valid DadosConsertoAlterar dados){
        PoucosDadosConsertoAlterado consertoAlterado=gerenciarConsertoService.alterar(id,dados);
        return ResponseEntity.ok(consertoAlterado);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        gerenciarConsertoService.excluirComAtivoFalse(id);
        return ResponseEntity.noContent().build();

    }



    @GetMapping
    public ResponseEntity<Page<DadosConserto>> returnAllConsertos(Pageable pageable){
        Page<DadosConserto> dadosConsertoPage= gerenciarConsertoService.returnAllConserto(pageable);
        return ResponseEntity.ok(dadosConsertoPage);
    }

    @GetMapping("/resumo")
    public ResponseEntity<List<PoucosDadosConserto>> simpleViewConsertos(){
        List<PoucosDadosConserto> poucosDadosConsertosList = gerenciarConsertoService.returnAllConsertoPoucosDados();
        return ResponseEntity.ok(poucosDadosConsertosList);
    }

    @GetMapping("/ativos")
    public ResponseEntity<Page<PoucosDadosConserto>> returnAllConsertoAtivoSimpleView(@PageableDefault (size=10,sort={"id"})
                                                                     Pageable pageable){
        Page<PoucosDadosConserto> poucosDadosConsertoPage =gerenciarConsertoService
                .returnAllConsertoAtivoPoucosDados(pageable);
        return ResponseEntity.ok(poucosDadosConsertoPage);

    }

    @GetMapping("{id}") ResponseEntity<PoucosDadosConserto> returnConsertoById (@PathVariable Long id){
        PoucosDadosConserto viewConserto = gerenciarConsertoService.returnConsertoById(id);
        return ResponseEntity.ok(viewConserto);

    }



}
