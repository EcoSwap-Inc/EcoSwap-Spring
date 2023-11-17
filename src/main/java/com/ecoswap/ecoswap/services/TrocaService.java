package com.ecoswap.ecoswap.services;

import com.ecoswap.ecoswap.domain.InputClasses.TrocaInput;
import com.ecoswap.ecoswap.domain.Produto;
import com.ecoswap.ecoswap.domain.Troca;
import com.ecoswap.ecoswap.exception.NoSuchElementFoundException;
import com.ecoswap.ecoswap.repository.AvaliacaoRepository;
import com.ecoswap.ecoswap.repository.ProdutoRepository;
import com.ecoswap.ecoswap.repository.TrocaRepository;
import com.ecoswap.ecoswap.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class TrocaService {

    @Autowired
    private TrocaRepository trocaRepository;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity<String> salvarTroca(Troca troca) {
        trocaRepository.save(troca);
        return ResponseEntity.status(HttpStatus.CREATED).body("{\"status\": \"201\", \"data\": \"" + LocalDateTime.now() + "\", \"mensagem\": \"Troca com ID " + troca.getId() + " inserida com sucesso\"}");
    }

    public List<Troca> listarTroca() {
        return trocaRepository.findAll();
    }

    public Troca findTrocaById(Long id) {
        return trocaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException("Troca não encontrada com o ID: " + id));
    }

    public ResponseEntity<String> deletarTroca(Long id) {
        if (trocaRepository.existsById(id))
            trocaRepository.deleteById(id);
        else
            throw new NoSuchElementFoundException("Troca não encontrada com o ID: " + id);
        return ResponseEntity.status(HttpStatus.OK).body("{\"status\": \"200\", \"data\": \"" + LocalDateTime.now() + "\", \"mensagem\": \"Troca com ID " + id + " deletada com sucesso\"}");
    }

    public List<Troca> findTrocasNovas() {
        return trocaRepository.findTop10ByFinalizadaIsFalseOrderByIdDesc();
    }

    public List<Troca> findTrocasPopulares() {
        return trocaRepository.findTop10ByFinalizadaIsFalseOrderByViewsDesc();
    }

    public List<Troca> findTrocasByCategoria(Long cat_id) {
        return trocaRepository.findByCategoria(cat_id);
    }

    public Troca findTrocaAtivaExistente(Long id) {
        return trocaRepository.findTrocaAtivaExistente(id);
    }

    public ResponseEntity<String> atualizarTroca(Long id, TrocaInput troca) {
        if (!troca.isFinalizada() && troca.getData_conclusao() == null && troca.getAvaliacao_id() == null && troca.getProduto_id() == null && troca.getUsuario_id() == null && troca.getViews() == 0)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"status\": \"400\", \"data\": \"" + LocalDateTime.now() + "\", \"mensagem\": \"Nenhum campo válido de 'Troca' foi informado\"}");

        Troca trocaExistente = trocaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException("Troca não encontrada com o ID: " + id));

        if (troca.getAvaliacao_id() != null) {
            Long avaliacao_id = troca.getAvaliacao_id();
            trocaExistente.setAvaliacao(avaliacaoRepository.findById(avaliacao_id).orElseThrow(() -> new NoSuchElementFoundException("Avaliação não encontrada com o ID: " + avaliacao_id)));
        }
        if (troca.getUsuario_id() != null) {
            Long usuario_id = troca.getUsuario_id();
            trocaExistente.setUsuario(usuarioRepository.findById(usuario_id).orElseThrow(() -> new NoSuchElementFoundException("Usuário não encontrado com o ID: " + usuario_id)));
        }
        if (troca.getProduto_id() != null) {
            Long produto_id = troca.getProduto_id();
            trocaExistente.setProduto(produtoRepository.findById(produto_id).orElseThrow(() -> new NoSuchElementFoundException("Produto não encontrado com o ID: " + produto_id)));
        }
        if (troca.isFinalizada() != trocaExistente.isFinalizada()) {
            trocaExistente.setFinalizada(troca.isFinalizada());
        }
        if (troca.getData_conclusao() != null) {
            trocaExistente.setData_conclusao(troca.getData_conclusao());
        }
        if (troca.getViews() != null) {
            trocaExistente.setViews(troca.getViews());
        }

        trocaRepository.save(trocaExistente);
        return ResponseEntity.status(HttpStatus.OK).body("{\"status\": \"200\", \"data\": \"" + LocalDateTime.now() + "\", \"mensagem\": \"Troca com ID " + id + " atualizada com sucesso\"}");
    }


}
