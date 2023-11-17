package com.ecoswap.ecoswap.services;

import com.ecoswap.ecoswap.domain.InputClasses.ProdutoInput;
import com.ecoswap.ecoswap.domain.Produto;
import com.ecoswap.ecoswap.exception.NoSuchElementFoundException;
import com.ecoswap.ecoswap.repository.CategoriaRepository;
import com.ecoswap.ecoswap.repository.ProdutoRepository;
import com.ecoswap.ecoswap.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    public ResponseEntity<String> salvarProduto(Produto produto) {
        produtoRepository.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body("{\"status\": \"201\", \"data\": \"" + LocalDateTime.now() + "\", \"mensagem\": \"Produto com ID " + produto.getId() + " inserido com sucesso\"}");
    }

    public List<Produto> listarProduto() {
        return produtoRepository.findAll();
    }

    public List<Produto> findProdutosByUsuario(Long id_usuario) {
        return produtoRepository.findByUsuario(id_usuario);
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

    public ResponseEntity<String> atualizarProduto(Long id, ProdutoInput produto) {
        if (produto.getCategoria_id() == null && produto.getNome() == null && produto.getUsuario_id() == null && produto.getImagem() == null && produto.getDescricao() == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"status\": \"400\", \"data\": \"" + LocalDateTime.now() + "\", \"mensagem\": \"Nenhum campo válido de 'Produto' foi informado\"}");

        Produto produtoExistente = produtoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException("Produto não encontrado com o ID: " + id));

        if (produto.getCategoria_id() != null) {
            Long cat_id = produto.getCategoria_id();
            produtoExistente.setCategoria(categoriaRepository.findById(cat_id).orElseThrow(() -> new NoSuchElementFoundException("Categoria não encontrada com o ID: " + cat_id)));
        }
        if (produto.getUsuario_id() != null) {
            Long user_id = produto.getUsuario_id();
            produtoExistente.setUsuario(usuarioRepository.findById(user_id).orElseThrow(() -> new NoSuchElementFoundException("Usuário não encontrado com o ID: " + user_id)));
        }
        if (produto.getNome() != null)
            produtoExistente.setNome(produto.getNome());
        if (produto.getImagem() != null)
            produtoExistente.setImagem(produto.getImagem());
        if (produto.getDescricao() != null)
            produtoExistente.setDescricao(produto.getDescricao());

        produtoRepository.save(produtoExistente);
        return ResponseEntity.status(HttpStatus.OK).body("{\"status\": \"200\", \"data\": \"" + LocalDateTime.now() + "\", \"mensagem\": \"Produto com ID " + id + " atualizado com sucesso\"}");
    }

}
