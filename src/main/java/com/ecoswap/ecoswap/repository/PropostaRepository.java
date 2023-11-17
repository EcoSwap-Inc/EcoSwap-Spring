package com.ecoswap.ecoswap.repository;

import com.ecoswap.ecoswap.domain.Proposta;
import com.ecoswap.ecoswap.domain.Troca;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PropostaRepository extends JpaRepository<Proposta, Long> {
    @Query("select p from Proposta p where p.troca.id = :troca")
    List<Proposta> findAllByTrocaId(Long troca);

    @Query("select p from Proposta p where (p.usuario.id_usuario = :id_usuario or p.troca.usuario.id_usuario = :id_usuario) and p.aceito = true")
    List<Proposta> findAllFinalizadas(Long id_usuario);

}
