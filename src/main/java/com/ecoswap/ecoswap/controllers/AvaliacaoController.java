package com.ecoswap.ecoswap.controllers;


import com.ecoswap.ecoswap.domain.Avaliacao;
import com.ecoswap.ecoswap.repository.AvaliacaoRepository;
import com.ecoswap.ecoswap.services.AvaliacaoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/avaliacao")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @PostMapping
    public Avaliacao salvarAvaliacao(@RequestBody Avaliacao avaliacao) {
        return avaliacaoService.salvarAvaliacao(avaliacao);
    }

    @GetMapping
    public List<Avaliacao> listarAvaliacao() {
        return avaliacaoService.listarAvaliacao();
    }

    @GetMapping("/{id}")
    public Avaliacao findAvaliacaoById(@PathVariable Long id) {
        return avaliacaoService.findAvaliacaoById(id);
    }

    @DeleteMapping("/{id}")
    public void deletarAvaliacao(@PathVariable Long id) {
        avaliacaoService.deletarAvaliacao(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Avaliacao> atualizarAvaliacao(@PathVariable Long id, @RequestBody Avaliacao avaliacao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(avaliacaoService.atualizarAvaliacao(id, avaliacao));
    }

}




