package com.ecoswap.ecoswap.controllers;


import com.ecoswap.ecoswap.domain.InputClasses.ProdutoInput;
import com.ecoswap.ecoswap.domain.Produto;
import com.ecoswap.ecoswap.services.ProdutoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/produto")
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

    @GetMapping("/categoria/{cat_id}")
    public ResponseEntity<List<Produto>> findProdutosByCategoria(@PathVariable @Positive Long cat_id) {
        return ResponseEntity.ok(produtoService.findProdutosByCategoria(cat_id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findProdutoById(@PathVariable @Positive Long id) {
        Produto produto = produtoService.findProdutoById(id);

        ProdutoInput input = new ProdutoInput();
        input.setViews(produto.getViews() + 1);
        produtoService.atualizarProduto(id, input);

        return ResponseEntity.status(HttpStatus.OK).body(produto);
    }

    @GetMapping("/img/{id}")
    public ResponseEntity<String> getImage(@PathVariable @Positive Long id) {
        var img = produtoService.findProdutoById(id).getImagem();
        return ResponseEntity.status(HttpStatus.OK).body("{\"imagem\": \"" + img + "\"}");
    }

    @GetMapping("/novos")
    public ResponseEntity<List<Produto>> findProdutosNovos() {
        return ResponseEntity.ok(produtoService.findProdutosNovos());
    }

    @GetMapping("/populares")
    public ResponseEntity<List<Produto>> findProdutosPopulares() {
        return ResponseEntity.ok(produtoService.findProdutosPopulares());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarProduto(@PathVariable @Positive Long id) {
        return produtoService.deletarProduto(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarProduto(@PathVariable @Positive Long id, @Valid @RequestBody ProdutoInput produto) {
        return produtoService.atualizarProduto(id, produto);
    }


}
