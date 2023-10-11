package com.ecoswap.ecoswap.services;

import com.ecoswap.ecoswap.domain.Avaliacao;
import com.ecoswap.ecoswap.repository.AvaliacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public Avaliacao salvarAvaliacao(Avaliacao Avaliacao) {
        return avaliacaoRepository.save(Avaliacao);
    }

    public List<Avaliacao> listarAvaliacao() {
        return avaliacaoRepository.findAll();
    }

    public Avaliacao findAvaliacaoById(Long id) {
        return avaliacaoRepository.findById(id).orElse(null);
    }

    public void deletarAvaliacao(Long id) {
        avaliacaoRepository.deleteById(id);
    }

    public Avaliacao atualizarAvaliacao(Long id, Avaliacao avaliacao) {
        Optional<Avaliacao> avaliacaoExistenteOptional = Optional.ofNullable(avaliacaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com o ID: " + id)));

        Avaliacao avaliacaoExistente = avaliacaoExistenteOptional.get();

        avaliacaoExistente.setAvaliacao_proposta(avaliacao.getAvaliacao_proposta());
        avaliacaoExistente.setAvaliacao_troca(avaliacao.getAvaliacao_troca());
        avaliacaoExistente.setProposta(avaliacao.getProposta());
        avaliacaoExistente.setUsuario_troca(avaliacao.getUsuario_troca());
        avaliacaoExistente.setUsuario_proposta(avaliacao.getUsuario_proposta());
        avaliacaoExistente.setTroca(avaliacao.getTroca());

        return avaliacaoRepository.save(avaliacaoExistente);
    }
}
