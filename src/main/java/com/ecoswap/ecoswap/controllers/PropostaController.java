package com.ecoswap.ecoswap.controllers;


import com.ecoswap.ecoswap.domain.Proposta;
import com.ecoswap.ecoswap.services.PropostaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/proposta")
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
    public Proposta findPropostaById(@PathVariable Long id) {
        return propostaService.findPropostaById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarProposta(@PathVariable Long id) {
        return propostaService.deletarProposta(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarProposta(@PathVariable Long id, @Valid @RequestBody Proposta proposta) {
        return propostaService.atualizarProposta(id, proposta);
    }


}
