package com.ecoswap.ecoswap.services;

import com.ecoswap.ecoswap.domain.Produto;
import com.ecoswap.ecoswap.exception.NoSuchElementFoundException;
import com.ecoswap.ecoswap.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public ResponseEntity<String> salvarProduto(Produto produto) {
        produtoRepository.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body("{\"status\": \"201\", \"data\": \"" + LocalDateTime.now() + "\", \"mensagem\": \"Produto com ID " + produto.getId_produto() + " inserido com sucesso\"}");
    }

    public List<Produto> listarProduto() {
        return produtoRepository.findAll();
    }

    public List<Produto> findProdutosByCategoria(Long cat_id) {
        return produtoRepository.findByCategoria(cat_id);
    }

    public Produto findProdutoById(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException("Produto não encontrado com o ID: " + id));
    }

    public ResponseEntity<String> deletarProduto(Long id) {
        if (produtoRepository.existsById(id))
            produtoRepository.deleteById(id);
        else
            throw new NoSuchElementFoundException("Produto não encontrado com o ID: " + id);
        return ResponseEntity.status(HttpStatus.OK).body("{\"status\": \"200\", \"data\": \"" + LocalDateTime.now() + "\", \"mensagem\": \"Produto com ID " + id + " deletado com sucesso\"}");
    }

    public ResponseEntity<String> atualizarProduto(Long id, Produto produto) {
        Produto produtoExistente = produtoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException("Produto não encontrado com o ID: " + id));


        produtoExistente.setCategoria(produto.getCategoria());
        produtoExistente.setNome(produto.getNome());
        produtoExistente.setUsuario(produto.getUsuario());

        produtoRepository.save(produtoExistente);
        return ResponseEntity.status(HttpStatus.OK).body("{\"status\": \"200\", \"data\": \"" + LocalDateTime.now() + "\", \"mensagem\": \"Produto com ID " + id + " atualizado com sucesso\"}");
    }

}
