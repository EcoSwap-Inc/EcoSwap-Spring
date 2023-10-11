package com.ecoswap.ecoswap.controllers;


import com.ecoswap.ecoswap.domain.Troca;
import com.ecoswap.ecoswap.domain.Troca;
import com.ecoswap.ecoswap.repository.TrocaRepository;
import com.ecoswap.ecoswap.services.TrocaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/troca")
public class TrocaController {


    @Autowired
    private TrocaService trocaService;

    @PostMapping
    public Troca salvarTroca(@RequestBody Troca Troca) {
        return trocaService.salvarTroca(Troca);
    }

    @GetMapping
    public List<Troca> listarTroca() {
        return trocaService.listarTroca();
    }

    @GetMapping("/{id}")
    public Troca findTrocaById(@PathVariable Long id) {
        return trocaService.findTrocaById(id);
    }

    @DeleteMapping("/{id}")
    public void deletarTroca(@PathVariable Long id) {
        trocaService.deletarTroca(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Troca> atualizarTroca(@PathVariable Long id, @RequestBody Troca troca) {
        return ResponseEntity.status(HttpStatus.CREATED).body(trocaService.atualizarTroca(id, troca));
    }

}
