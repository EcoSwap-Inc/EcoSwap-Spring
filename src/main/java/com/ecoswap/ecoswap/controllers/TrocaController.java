package com.ecoswap.ecoswap.controllers;


import com.ecoswap.ecoswap.domain.Troca;
import com.ecoswap.ecoswap.services.TrocaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/troca")
public class TrocaController {


    @Autowired
    private TrocaService trocaService;

    @PostMapping("/")
    public ResponseEntity<String> salvarTroca(@Valid @RequestBody Troca Troca) {
        return trocaService.salvarTroca(Troca);
    }

    @GetMapping("/")
    public List<Troca> listarTroca() {
        return trocaService.listarTroca();
    }

    @GetMapping("/{id}")
    public Troca findTrocaById(@PathVariable @Positive Long id) {
        return trocaService.findTrocaById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarTroca(@PathVariable @Positive Long id) {
        return trocaService.deletarTroca(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarTroca(@PathVariable @Positive Long id, @Valid @RequestBody Troca troca) {
        return trocaService.atualizarTroca(id, troca);
    }

}
