package com.ecoswap.ecoswap.services;

import com.ecoswap.ecoswap.domain.Categoria;
import com.ecoswap.ecoswap.domain.Categoria;
import com.ecoswap.ecoswap.repository.CategoriaRepository;
import com.ecoswap.ecoswap.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {


    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria salvarCategoria(Categoria Categoria) {
        return categoriaRepository.save(Categoria);
    }

    public List<Categoria> listarCategoria() {
        return categoriaRepository.findAll();
    }

    public Categoria findCategoriaById(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public void deletarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }

    public Categoria atualizarCategoria(Long id, Categoria categoria) {
        Optional<Categoria> categoriaExistenteOptional = Optional.ofNullable(categoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com o ID: " + id)));

        Categoria categoriaExistente = categoriaExistenteOptional.get();

       categoriaExistente.setNome(categoria.getNome());
       categoriaExistente.setProdutosList(categoria.getProdutosList());

        return categoriaRepository.save(categoriaExistente);
    }
}
