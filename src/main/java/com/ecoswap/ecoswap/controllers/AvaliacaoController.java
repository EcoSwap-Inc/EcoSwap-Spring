package com.ecoswap.ecoswap.controllers;


import com.ecoswap.ecoswap.domain.Avaliacao;
import com.ecoswap.ecoswap.domain.InputClasses.AvaliacaoInput;
import com.ecoswap.ecoswap.services.AvaliacaoService;
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
@RequestMapping(path = "/api/avaliacao")
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
    public Avaliacao findAvaliacaoById(@PathVariable @Positive Long id) {
        return avaliacaoService.findAvaliacaoById(id);
    }

    @GetMapping("/mediaTrocas/{id}")
    public ResponseEntity<String> getAvMediaTrocasUsuario(@PathVariable @Positive Long id) {
        return avaliacaoService.getAvMediaTrocasUsuario(id);
    }

    @GetMapping("/mediaPropostas/{id}")
    public ResponseEntity<String> getAvMediaPropostasUsuario(@PathVariable @Positive Long id) {
        return avaliacaoService.getAvMediaPropostasUsuario(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarAvaliacao(@PathVariable @Positive Long id) {
        return avaliacaoService.deletarAvaliacao(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarAvaliacao(@PathVariable @Positive Long id, @Valid @RequestBody AvaliacaoInput avaliacao) {
        return avaliacaoService.atualizarAvaliacao(id, avaliacao);
    }
}




