package com.ecoswap.ecoswap.controllers;


import com.ecoswap.ecoswap.domain.Avaliacao;
import com.ecoswap.ecoswap.services.AvaliacaoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/avaliacao")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @PostMapping("/")
    public ResponseEntity<String> salvarAvaliacao(@Valid @RequestBody Avaliacao avaliacao) {
        return avaliacaoService.salvarAvaliacao(avaliacao);
    }

    @GetMapping("/")
    public List<Avaliacao> listarAvaliacao() {
        return avaliacaoService.listarAvaliacao();
    }

    @GetMapping("/{id}")
    public Avaliacao findAvaliacaoById(@PathVariable Long id) {
        return avaliacaoService.findAvaliacaoById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarAvaliacao(@PathVariable Long id) {
        return avaliacaoService.deletarAvaliacao(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarAvaliacao(@PathVariable Long id, @Valid @RequestBody Avaliacao avaliacao) {
        return avaliacaoService.atualizarAvaliacao(id, avaliacao);
    }
}




