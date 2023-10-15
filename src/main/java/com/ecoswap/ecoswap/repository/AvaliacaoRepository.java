package com.ecoswap.ecoswap.repository;

import com.ecoswap.ecoswap.domain.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    @Query("select coalesce(AVG(a.avaliacao_troca), 0) from Avaliacao a where a.usuario_troca.id_usuario = :id_usuario and a.avaliacao_troca != null")
    BigDecimal getAvMediaTrocasUsuario(@Param("id_usuario") Long id_usuario);

    @Query("select coalesce(AVG(a.avaliacao_proposta), 0) from Avaliacao a where a.usuario_proposta.id_usuario = :id_usuario and a.avaliacao_proposta != null")
    BigDecimal getAvMediaPropostasUsuario(@Param("id_usuario") Long id_usuario);
}
