package com.ecoswap.ecoswap.services;

import com.ecoswap.ecoswap.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
