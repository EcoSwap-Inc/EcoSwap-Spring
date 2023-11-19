package com.ecoswap.ecoswap.repository;

import com.ecoswap.ecoswap.domain.Troca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrocaRepository extends JpaRepository<Troca, Long> {
    @Query("select t from Troca t where t.produto.categoria.id_categoria = :categoria and t.finalizada = false")
    List<Troca> findByCategoria(@Param("categoria") Long categoria);

    @Query("select t from Troca t where t.usuario.id_usuario = :id_usuario and t.finalizada = true")
    List<Troca> findAllFinalizadas(Long id_usuario);

    List<Troca> findTop10ByFinalizadaIsFalseOrderByIdDesc();

    List<Troca> findTop10ByFinalizadaIsFalseOrderByViewsDesc();

    @Query("select t from Troca t where t.produto.id = :produto and t.finalizada = false")
    Troca findTrocaAtivaExistente(@Param("produto") Long produto);
}
