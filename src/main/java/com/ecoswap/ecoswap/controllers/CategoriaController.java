package com.ecoswap.ecoswap.controllers;


import com.ecoswap.ecoswap.domain.Avaliacao;
import com.ecoswap.ecoswap.domain.Categoria;
import com.ecoswap.ecoswap.repository.CategoriaRepository;
import com.ecoswap.ecoswap.services.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/categoria")
public class CategoriaController {


    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public Categoria salvarCategoria(@RequestBody Categoria Categoria) {
        return categoriaService.salvarCategoria(Categoria);
    }

    @GetMapping
    public List<Categoria> listarCategoria() {
        return categoriaService.listarCategoria();
    }

    @GetMapping("/{id}")
    public Categoria findCategoriaById(@PathVariable Long id) {
        return categoriaService.findCategoriaById(id);
    }

    @DeleteMapping("/{id}")
    public void deletarCategoria(@PathVariable Long id) {
        categoriaService.deletarCategoria(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.atualizarCategoria(id, categoria));
    }

}
