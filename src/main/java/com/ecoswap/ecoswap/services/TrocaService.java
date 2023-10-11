package com.ecoswap.ecoswap.services;

import com.ecoswap.ecoswap.domain.Troca;
import com.ecoswap.ecoswap.domain.Troca;
import com.ecoswap.ecoswap.repository.TrocaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrocaService {

    @Autowired
    private TrocaRepository trocaRepository;

    public Troca salvarTroca(Troca Troca) {
        return trocaRepository.save(Troca);
    }

    public List<Troca> listarTroca() {
        return trocaRepository.findAll();
    }

    public Troca findTrocaById(Long id) {
        return trocaRepository.findById(id).orElse(null);
    }

    public void deletarTroca(Long id) {
        trocaRepository.deleteById(id);
    }

    public Troca atualizarTroca(Long id, Troca troca) {
        Optional<Troca> trocaExistenteOptional = Optional.ofNullable(trocaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com o ID: " + id)));

        Troca trocaExistente = trocaExistenteOptional.get();

        trocaExistente.setAvaliacao(troca.getAvaliacao());
        trocaExistente.setProduto(troca.getProduto());
        trocaExistente.setFinalizada(troca.isFinalizada());
        trocaExistente.setUsuario(troca.getUsuario());
        trocaExistente.setData_criacao(troca.getData_criacao());
        trocaExistente.setData_conclusao(troca.getData_conclusao());

        return trocaRepository.save(trocaExistente);
    }


}
