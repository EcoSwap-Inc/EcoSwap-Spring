package com.ecoswap.ecoswap.services;

import com.ecoswap.ecoswap.domain.Proposta;
import com.ecoswap.ecoswap.domain.Proposta;
import com.ecoswap.ecoswap.repository.PropostaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropostaService {


    @Autowired
    private PropostaRepository propostaRepository;

    public Proposta salvarProposta(Proposta Proposta) {
        return propostaRepository.save(Proposta);
    }

    public List<Proposta> listarProposta() {
        return propostaRepository.findAll();
    }

    public Proposta findPropostaById(Long id) {
        return propostaRepository.findById(id).orElse(null);
    }

    public void deletarProposta(Long id) {
        propostaRepository.deleteById(id);
    }

    public Proposta atualizarProposta(Long id, Proposta proposta) {
        Optional<Proposta> propostaExistenteOptional = Optional.ofNullable(propostaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Proposta não encontrado com o ID: " + id)));

        Proposta propostaExistente = propostaExistenteOptional.get();

        propostaExistente.setAceito(proposta.isAceito());
        propostaExistente.setTroca(proposta.getTroca());
        propostaExistente.setAvaliacao(proposta.getAvaliacao());
        propostaExistente.setProduto(proposta.getProduto());
        propostaExistente.setUsuario(proposta.getUsuario());
        propostaExistente.setData_criacao(proposta.getData_criacao());
        propostaExistente.setData_conclusao(proposta.getData_conclusao());

        return propostaRepository.save(propostaExistente);
    }

}
