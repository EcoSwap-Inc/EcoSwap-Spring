package com.ecoswap.ecoswap.services;

import com.ecoswap.ecoswap.domain.InputClasses.PropostaInput;
import com.ecoswap.ecoswap.domain.Proposta;
import com.ecoswap.ecoswap.exception.NoSuchElementFoundException;
import com.ecoswap.ecoswap.repository.*;
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

    @Autowired
    private TrocaRepository trocaRepository;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

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

    public ResponseEntity<String> atualizarProposta(Long id, PropostaInput proposta) {
        if (!proposta.isAceito() && proposta.getData_criacao() == null && proposta.getData_conclusao() == null && proposta.getAvaliacao_id() != null && proposta.getProduto_id() == null && proposta.getTroca_id() == null && proposta.getUsuario_id() == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"status\": \"400\", \"data\": \"" + LocalDateTime.now() + "\", \"mensagem\": \"Nenhum campo válido de 'Proposta' foi informado\"}");

        Proposta propostaExistente = propostaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException("Proposta não encontrada com o ID: " + id));

        if (proposta.isAceito() != propostaExistente.isAceito()) {
            propostaExistente.setAceito(proposta.isAceito());
        }
        if (proposta.getTroca_id() != null) {
            Long troca_id = proposta.getTroca_id();
            propostaExistente.setTroca(trocaRepository.findById(troca_id).orElseThrow(() -> new NoSuchElementFoundException("Troca não encontrada com o ID: " + troca_id)));
        }
        if (proposta.getAvaliacao_id() != null) {
            Long avaliacao_id = proposta.getAvaliacao_id();
            propostaExistente.setAvaliacao(avaliacaoRepository.findById(avaliacao_id).orElseThrow(() -> new NoSuchElementFoundException("Avaliação não encontrada com o ID: " + avaliacao_id)));
        }
        if (proposta.getProduto_id() != null) {
            Long produto_id = proposta.getProduto_id();
            propostaExistente.setProduto(produtoRepository.findById(produto_id).orElseThrow(() -> new NoSuchElementFoundException("Produto não encontrado com o ID: " + produto_id)));
        }
        if (proposta.getUsuario_id() != null) {
            Long usuario_id = proposta.getUsuario_id();
            propostaExistente.setUsuario(usuarioRepository.findById(usuario_id).orElseThrow(() -> new NoSuchElementFoundException("Usuario não encontrado com o ID: " + usuario_id)));
        }
        if (proposta.getData_conclusao() != null) {
            propostaExistente.setData_criacao(proposta.getData_criacao());
        }
        if (proposta.getData_criacao() != null) {
            propostaExistente.setData_conclusao(proposta.getData_conclusao());
        }

        propostaRepository.save(propostaExistente);
        return ResponseEntity.status(HttpStatus.OK).body("{\"status\": \"200\", \"data\": \"" + LocalDateTime.now() + "\", \"mensagem\": \"Proposta com ID " + id + " atualizada com sucesso\"}");
    }

}
