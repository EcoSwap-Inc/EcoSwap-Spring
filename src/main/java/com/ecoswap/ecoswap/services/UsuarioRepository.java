package com.ecoswap.ecoswap.services;

import com.ecoswap.ecoswap.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
