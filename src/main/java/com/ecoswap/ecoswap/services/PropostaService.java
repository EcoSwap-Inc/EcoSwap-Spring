package com.ecoswap.ecoswap.services;

import com.ecoswap.ecoswap.domain.Proposta;
import com.ecoswap.ecoswap.exception.NoSuchElementFoundException;
import com.ecoswap.ecoswap.repository.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PropostaService {


    @Autowired
    private PropostaRepository propostaRepository;

    public ResponseEntity<String> salvarProposta(Proposta proposta) {
        propostaRepository.save(proposta);
        return ResponseEntity.status(HttpStatus.CREATED).body("{\"status\": \"201\", \"data\": \"" + LocalDateTime.now() + "\", \"mensagem\": \"Proposta com ID " + proposta.getId_proposta() + " inserida com sucesso\"}");
    }

    public List<Proposta> listarProposta() {
        return propostaRepository.findAll();
    }

    public Proposta findPropostaById(Long id) {
        return propostaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException("Proposta não encontrada com o ID: " + id));
    }

    public ResponseEntity<String> deletarProposta(Long id) {
        if (propostaRepository.existsById(id))
            propostaRepository.deleteById(id);
        else
            throw new NoSuchElementFoundException("Proposta não encontrada com o ID: " + id);
        return ResponseEntity.status(HttpStatus.OK).body("{\"status\": \"200\", \"data\": \"" + LocalDateTime.now() + "\", \"mensagem\": \"Proposta com ID " + id + " deletada com sucesso\"}");
    }

    public ResponseEntity<String> atualizarProposta(Long id, Proposta proposta) {
        Proposta propostaExistente = propostaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException("Proposta não encontrada com o ID: " + id));

        propostaExistente.setAceito(proposta.isAceito());
        propostaExistente.setTroca(proposta.getTroca());
        propostaExistente.setAvaliacao(proposta.getAvaliacao());
        propostaExistente.setProduto(proposta.getProduto());
        propostaExistente.setUsuario(proposta.getUsuario());
        propostaExistente.setData_criacao(proposta.getData_criacao());
        propostaExistente.setData_conclusao(proposta.getData_conclusao());

        propostaRepository.save(propostaExistente);
        return ResponseEntity.status(HttpStatus.OK).body("{\"status\": \"200\", \"data\": \"" + LocalDateTime.now() + "\", \"mensagem\": \"Proposta com ID " + id + " atualizada com sucesso\"}");
    }

}
