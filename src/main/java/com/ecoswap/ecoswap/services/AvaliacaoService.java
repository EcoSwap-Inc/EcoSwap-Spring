package com.ecoswap.ecoswap.services;

import com.ecoswap.ecoswap.domain.Avaliacao;
import com.ecoswap.ecoswap.exception.NoSuchElementFoundException;
import com.ecoswap.ecoswap.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public ResponseEntity<String> salvarAvaliacao(Avaliacao avaliacao) {
        avaliacaoRepository.save(avaliacao);
        return ResponseEntity.status(HttpStatus.CREATED).body("{\"status\": \"201\", \"data\": \"" + LocalDateTime.now() + "\", \"mensagem\": \"Avaliação com ID " + avaliacao.getId_avaliacao() + " inserida com sucesso\"}");
    }

    public List<Avaliacao> listarAvaliacao() {
        return avaliacaoRepository.findAll();
    }

    public Avaliacao findAvaliacaoById(Long id) {
        return avaliacaoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException("Avaliação não encontrada com o ID: " + id));
    }

    public ResponseEntity<String> deletarAvaliacao(Long id) {
        avaliacaoRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("{\"status\": \"200\", \"data\": \"" + LocalDateTime.now() + "\", \"mensagem\": \"Avaliação com ID " + id + " deletada com sucesso\"}");
    }

    public ResponseEntity<String> atualizarAvaliacao(Long id, Avaliacao avaliacao) {
        Avaliacao avaliacaoExistente = avaliacaoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException("Avaliação não encontrada com o ID: " + id));

        avaliacaoExistente.setAvaliacao_proposta(avaliacao.getAvaliacao_proposta());
        avaliacaoExistente.setAvaliacao_troca(avaliacao.getAvaliacao_troca());
        avaliacaoExistente.setProposta(avaliacao.getProposta());
        avaliacaoExistente.setUsuario_troca(avaliacao.getUsuario_troca());
        avaliacaoExistente.setUsuario_proposta(avaliacao.getUsuario_proposta());
        avaliacaoExistente.setTroca(avaliacao.getTroca());

        avaliacaoRepository.save(avaliacaoExistente);
        return ResponseEntity.status(HttpStatus.OK).body("{\"status\": \"200\", \"data\": \"" + LocalDateTime.now() + "\", \"mensagem\": \"Avaliação com ID " + avaliacao.getId_avaliacao() + " atualizada com sucesso\"}");
    }
}
