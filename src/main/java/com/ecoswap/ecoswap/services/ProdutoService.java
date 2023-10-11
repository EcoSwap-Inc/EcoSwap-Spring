package com.ecoswap.ecoswap.services;

import com.ecoswap.ecoswap.domain.Produto;
import com.ecoswap.ecoswap.domain.Produto;
import com.ecoswap.ecoswap.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {


    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvarProduto(Produto Produto) {
        return produtoRepository.save(Produto);
    }

    public List<Produto> listarProduto() {
        return produtoRepository.findAll();
    }

    public Produto findProdutoById(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    public Produto atualizarProduto(Long id, Produto produto) {
        Optional<Produto> produtoExistenteOptional = Optional.ofNullable(produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com o ID: " + id)));

        Produto produtoExistente = produtoExistenteOptional.get();

        produtoExistente.setCategoria(produto.getCategoria());
        produtoExistente.setNome(produto.getNome());
        produtoExistente.setUsuario(produto.getUsuario());

        return produtoRepository.save(produtoExistente);
    }

}
