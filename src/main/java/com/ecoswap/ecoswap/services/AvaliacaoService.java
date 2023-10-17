package com.ecoswap.ecoswap.services;

import com.ecoswap.ecoswap.domain.Avaliacao;
import com.ecoswap.ecoswap.domain.InputClasses.AvaliacaoInput;
import com.ecoswap.ecoswap.exception.NoSuchElementFoundException;
import com.ecoswap.ecoswap.repository.AvaliacaoRepository;
import com.ecoswap.ecoswap.repository.PropostaRepository;
import com.ecoswap.ecoswap.repository.TrocaRepository;
import com.ecoswap.ecoswap.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TrocaRepository trocaRepository;

    @Autowired
    private PropostaRepository propostaRepository;

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

    public ResponseEntity<String> getAvMediaTrocasUsuario(Long id) {
        if (usuarioRepository.existsById(id))
            return ResponseEntity.status(HttpStatus.OK).body("{\"status\": \"200\", \"data\": \"" + LocalDateTime.now() + "\", \"resultado\": " + avaliacaoRepository.getAvMediaTrocasUsuario(id) + "}");
        else
            throw new NoSuchElementFoundException("Usuário não encontrado com o ID: " + id);
    }

    public ResponseEntity<String> getAvMediaPropostasUsuario(Long id) {
        if (usuarioRepository.existsById(id))
            return ResponseEntity.status(HttpStatus.OK).body("{\"status\": \"200\", \"data\": \"" + LocalDateTime.now() + "\", \"resultado\": " + avaliacaoRepository.getAvMediaPropostasUsuario(id) + "}");
        else
            throw new NoSuchElementFoundException("Usuário não encontrado com o ID: " + id);
    }

    public ResponseEntity<String> deletarAvaliacao(Long id) {
        if (avaliacaoRepository.existsById(id))
            avaliacaoRepository.deleteById(id);
        else
            throw new NoSuchElementFoundException("Avaliação não encontrada com o ID: " + id);
        return ResponseEntity.status(HttpStatus.OK).body("{\"status\": \"200\", \"data\": \"" + LocalDateTime.now() + "\", \"mensagem\": \"Avaliação com ID " + id + " deletada com sucesso\"}");
    }

    public ResponseEntity<String> atualizarAvaliacao(Long id, AvaliacaoInput avaliacao) {
        if (avaliacao.getAvaliacao_proposta() == 0 && avaliacao.getAvaliacao_troca() == 0 && avaliacao.getProposta_id() == null && avaliacao.getTroca_id() == null && avaliacao.getUsuario_proposta_id() == null && avaliacao.getUsuario_troca_id() == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"status\": \"400\", \"data\": \"" + LocalDateTime.now() + "\", \"mensagem\": \"Nenhum campo válido de 'Avaliação' foi informado\"}");

        Avaliacao avaliacaoExistente = avaliacaoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException("Avaliação não encontrada com o ID: " + id));

        if (avaliacao.getAvaliacao_proposta() != avaliacaoExistente.getAvaliacao_proposta()) {
            avaliacaoExistente.setAvaliacao_proposta(avaliacao.getAvaliacao_proposta());
        }
        if (avaliacao.getAvaliacao_troca() != avaliacaoExistente.getAvaliacao_troca()) {
            avaliacaoExistente.setAvaliacao_troca(avaliacao.getAvaliacao_troca());
        }
        if (avaliacao.getProposta_id() != null) {
            Long prop_id = avaliacao.getProposta_id();
            avaliacaoExistente.setProposta(propostaRepository.findById(prop_id).orElseThrow(() -> new NoSuchElementFoundException("Proposta não encontrada com o ID: " + prop_id)));
        }
        if (avaliacao.getTroca_id() != null) {
            Long troca_id = avaliacao.getTroca_id();
            avaliacaoExistente.setTroca(trocaRepository.findById(troca_id).orElseThrow(() -> new NoSuchElementFoundException("Proposta não encontrada com o ID: " + troca_id)));

        }
        if (avaliacao.getUsuario_troca_id() != null) {
            Long user_id = avaliacao.getUsuario_troca_id();
            avaliacaoExistente.setUsuario_troca(usuarioRepository.findById(user_id).orElseThrow(() -> new NoSuchElementFoundException("Usuário não encontrada com o ID: " + user_id)));
        }
        if (avaliacao.getUsuario_proposta_id() != null) {
            Long user_id = avaliacao.getUsuario_proposta_id();
            avaliacaoExistente.setUsuario_proposta(usuarioRepository.findById(user_id).orElseThrow(() -> new NoSuchElementFoundException("Usuário não encontrada com o ID: " + user_id)));
        }

        avaliacaoRepository.save(avaliacaoExistente);
        return ResponseEntity.status(HttpStatus.OK).body("{\"status\": \"200\", \"data\": \"" + LocalDateTime.now() + "\", \"mensagem\": \"Avaliação com ID " + id + " atualizada com sucesso\"}");
    }
}
