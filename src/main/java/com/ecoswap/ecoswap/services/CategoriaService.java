package com.ecoswap.ecoswap.services;

import com.ecoswap.ecoswap.domain.Categoria;
import com.ecoswap.ecoswap.domain.InputClasses.CategoriaInput;
import com.ecoswap.ecoswap.exception.NoSuchElementFoundException;
import com.ecoswap.ecoswap.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoriaService {


    @Autowired
    private CategoriaRepository categoriaRepository;

    public ResponseEntity<String> salvarCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body("{\"status\": \"201\", \"data\": \"" + LocalDateTime.now() + "\", \"mensagem\": \"Categoria com ID " + categoria.getId_categoria() + " inserida com sucesso\"}");
    }

    public List<Categoria> listarCategoria() {
        return categoriaRepository.findAll();
    }

    public Categoria findCategoriaById(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException("Categoria não encontrada com o ID: " + id));
    }

    public ResponseEntity<String> deletarCategoria(Long id) {
        if (categoriaRepository.existsById(id))
            categoriaRepository.deleteById(id);
        else
            throw new NoSuchElementFoundException("Categoria não encontrada com o ID: " + id);
        return ResponseEntity.status(HttpStatus.OK).body("{\"status\": \"200\", \"data\": \"" + LocalDateTime.now() + "\", \"mensagem\": \"Categoria com ID " + id + " deletada com sucesso\"}");
    }

    public ResponseEntity<String> atualizarCategoria(Long id, CategoriaInput categoria) {
        if (categoria.getNome() == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"status\": \"400\", \"data\": \"" + LocalDateTime.now() + "\", \"mensagem\": \"Nenhum campo válido de 'Categoria' foi informado\"}");

        Categoria categoriaExistente = categoriaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException("Categoria não encontrada com o ID: " + id));

        categoriaExistente.setNome(categoria.getNome());

        categoriaRepository.save(categoriaExistente);
        return ResponseEntity.status(HttpStatus.OK).body("{\"status\": \"200\", \"data\": \"" + LocalDateTime.now() + "\", \"mensagem\": \"Categoria com ID " + id + " atualizada com sucesso\"}");
    }
}
