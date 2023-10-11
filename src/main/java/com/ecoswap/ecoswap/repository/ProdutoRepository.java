package com.ecoswap.ecoswap.repository;

import com.ecoswap.ecoswap.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}