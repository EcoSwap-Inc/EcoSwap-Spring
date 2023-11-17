package com.ecoswap.ecoswap.controllers;


import com.ecoswap.ecoswap.domain.InputClasses.PropostaInput;
import com.ecoswap.ecoswap.domain.Proposta;
import com.ecoswap.ecoswap.services.PropostaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/proposta")
public class PropostaController {

    @Autowired
    private PropostaService propostaService;

    @PostMapping("/")
    public ResponseEntity<String> salvarProposta(@Valid @RequestBody Proposta Proposta) {
        return propostaService.salvarProposta(Proposta);
    }

    @GetMapping("/")
    public List<Proposta> listarProposta() {
        return propostaService.listarProposta();
    }

    @GetMapping("/{id}")
    public Proposta findPropostaById(@PathVariable @Positive Long id) {
        return propostaService.findPropostaById(id);
    }

    @GetMapping("/troca/{id}")
    public List<Proposta> findPropostasByTrocaId(@PathVariable @Positive Long id) {
        return propostaService.findPropostasByTrocaId(id);
    }

    @GetMapping("/finalizadas/{id}")
    public List<Proposta> findAllFinalizadas(@PathVariable @Positive Long id) {
        return propostaService.findAllPropostasFinalizadas(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarProposta(@PathVariable @Positive Long id) {
        return propostaService.deletarProposta(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarProposta(@PathVariable @Positive Long id, @Valid @RequestBody PropostaInput proposta) {
        return propostaService.atualizarProposta(id, proposta);
    }


}
