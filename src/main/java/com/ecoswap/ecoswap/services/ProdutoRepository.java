package com.ecoswap.ecoswap.services;

import com.ecoswap.ecoswap.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
