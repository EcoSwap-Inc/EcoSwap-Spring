package com.ecoswap.ecoswap.controllers;


import com.ecoswap.ecoswap.domain.Produto;
import com.ecoswap.ecoswap.services.ProdutoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/")
    public ResponseEntity<String> salvarProduto(@Valid @RequestBody Produto Produto) {
        return produtoService.salvarProduto(Produto);
    }

    @GetMapping("/")
    public ResponseEntity<List<Produto>> listarProduto() {
        return ResponseEntity.ok(produtoService.listarProduto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findProdutoById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findProdutoById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarProduto(@PathVariable Long id) {
        return produtoService.deletarProduto(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarProduto(@PathVariable Long id, @Valid @RequestBody Produto produto) {
        return produtoService.atualizarProduto(id, produto);
    }

}
