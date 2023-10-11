package com.ecoswap.ecoswap.controllers;


import com.ecoswap.ecoswap.domain.Proposta;
import com.ecoswap.ecoswap.domain.Proposta;
import com.ecoswap.ecoswap.repository.PropostaRepository;
import com.ecoswap.ecoswap.services.PropostaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/proposta")
public class PropostaController {

    @Autowired
    private PropostaService propostaService;

    @PostMapping
    public Proposta salvarProposta(@RequestBody Proposta Proposta) {
        return propostaService.salvarProposta(Proposta);
    }

    @GetMapping
    public List<Proposta> listarProposta() {
        return propostaService.listarProposta();
    }

    @GetMapping("/{id}")
    public Proposta findPropostaById(@PathVariable Long id) {
        return propostaService.findPropostaById(id);
    }

    @DeleteMapping("/{id}")
    public void deletarProposta(@PathVariable Long id) {
        propostaService.deletarProposta(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proposta> atualizarProposta(@PathVariable Long id, @RequestBody Proposta proposta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(propostaService.atualizarProposta(id, proposta));
    }



}
