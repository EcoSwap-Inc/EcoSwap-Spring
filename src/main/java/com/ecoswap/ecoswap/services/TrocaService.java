package com.ecoswap.ecoswap.services;

import com.ecoswap.ecoswap.domain.Troca;
import com.ecoswap.ecoswap.exception.NoSuchElementFoundException;
import com.ecoswap.ecoswap.repository.TrocaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TrocaService {

    @Autowired
    private TrocaRepository trocaRepository;

    public ResponseEntity<String> salvarTroca(Troca troca) {
        trocaRepository.save(troca);
        return ResponseEntity.status(HttpStatus.CREATED).body("{\"status\": \"201\", \"data\": \"" + LocalDateTime.now() + "\", \"mensagem\": \"Troca com ID " + troca.getId_troca() + " inserida com sucesso\"}");
    }

    public List<Troca> listarTroca() {
        return trocaRepository.findAll();
    }

    public Troca findTrocaById(Long id) {
        return trocaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException("Troca não encontrada com o ID: " + id));
    }

    public ResponseEntity<String> deletarTroca(Long id) {
        trocaRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("{\"status\": \"200\", \"data\": \"" + LocalDateTime.now() + "\", \"mensagem\": \"Troca com ID " + id + " deletada com sucesso\"}");
    }

    public ResponseEntity<String> atualizarTroca(Long id, Troca troca) {
        Troca trocaExistente = trocaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException("Troca não encontrada com o ID: " + id));

        trocaExistente.setAvaliacao(troca.getAvaliacao());
        trocaExistente.setProduto(troca.getProduto());
        trocaExistente.setFinalizada(troca.isFinalizada());
        trocaExistente.setUsuario(troca.getUsuario());
        trocaExistente.setData_criacao(troca.getData_criacao());
        trocaExistente.setData_conclusao(troca.getData_conclusao());

        trocaRepository.save(trocaExistente);
        return ResponseEntity.status(HttpStatus.OK).body("{\"status\": \"200\", \"data\": \"" + LocalDateTime.now() + "\", \"mensagem\": \"Troca com ID " + id + " atualizada com sucesso\"}");
    }


}
