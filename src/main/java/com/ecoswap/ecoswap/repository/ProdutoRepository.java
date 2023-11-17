package com.ecoswap.ecoswap.repository;

import com.ecoswap.ecoswap.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    @Query("select p from Produto p where p.categoria.id_categoria = :categoria")
    List<Produto> findByCategoria(@Param("categoria") Long categoria);

    @Query("select p from Produto p where p.usuario.id_usuario = :usuario")
    List<Produto> findByUsuario(@Param("usuario") Long usuario);

    public List<Produto> findTop10ByOrderByIdDesc();

}
