package com.ecoswap.ecoswap.controllers;


import com.ecoswap.ecoswap.domain.InputClasses.TrocaInput;
import com.ecoswap.ecoswap.domain.Troca;
import com.ecoswap.ecoswap.services.TrocaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/troca")
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
        Troca troca = trocaService.findTrocaById(id);

        TrocaInput input = new TrocaInput();
        input.setViews(troca.getViews() + 1);
        trocaService.atualizarTroca(id, input);

        return trocaService.findTrocaById(id);
    }

    @GetMapping("/existe/{id}")
    public ResponseEntity findTrocaAtivaExistente(@PathVariable @Positive Long id) {
        Troca troca = trocaService.findTrocaAtivaExistente(id);
        return ResponseEntity.ok(Objects.requireNonNullElse(troca, false));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarTroca(@PathVariable @Positive Long id) {
        return trocaService.deletarTroca(id);
    }

    @GetMapping("/novos")
    public ResponseEntity<List<Troca>> findTrocasNovas() {
        return ResponseEntity.ok(trocaService.findTrocasNovas());
    }

    @GetMapping("/populares")
    public ResponseEntity<List<Troca>> findTrocasPopulares() {
        return ResponseEntity.ok(trocaService.findTrocasPopulares());
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<Troca>> findProdutosByCategoria(@PathVariable @Positive Long id) {
        return ResponseEntity.ok(trocaService.findTrocasByCategoria(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarTroca(@PathVariable @Positive Long id, @Valid @RequestBody TrocaInput troca) {
        return trocaService.atualizarTroca(id, troca);
    }

}
