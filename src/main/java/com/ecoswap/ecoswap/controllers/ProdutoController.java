package com.ecoswap.ecoswap.controllers;


import com.ecoswap.ecoswap.domain.Produto;
import com.ecoswap.ecoswap.domain.Produto;
import com.ecoswap.ecoswap.repository.ProdutoRepository;
import com.ecoswap.ecoswap.services.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto Produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.salvarProduto(Produto));
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
    public void deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.atualizarProduto(id, produto));
    }

}
