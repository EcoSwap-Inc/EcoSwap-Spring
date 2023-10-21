package com.ecoswap.ecoswap.controllers;


import com.ecoswap.ecoswap.domain.Categoria;
import com.ecoswap.ecoswap.domain.InputClasses.CategoriaInput;
import com.ecoswap.ecoswap.services.CategoriaService;
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
@RequestMapping(path = "/api/categoria")
public class CategoriaController {


    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/")
    public ResponseEntity<String> salvarCategoria(@Valid @RequestBody Categoria Categoria) {
        return categoriaService.salvarCategoria(Categoria);
    }

    @GetMapping("/")
    public List<Categoria> listarCategoria() {
        return categoriaService.listarCategoria();
    }

    @GetMapping("/{id}")
    public Categoria findCategoriaById(@PathVariable @Positive Long id) {
        return categoriaService.findCategoriaById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCategoria(@PathVariable @Positive Long id) {
        return categoriaService.deletarCategoria(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarCategoria(@PathVariable @Positive Long id, @Valid @RequestBody CategoriaInput categoria) {
        return categoriaService.atualizarCategoria(id, categoria);
    }
}
