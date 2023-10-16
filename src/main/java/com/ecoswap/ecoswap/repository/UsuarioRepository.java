package com.ecoswap.ecoswap.repository;

import com.ecoswap.ecoswap.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("select case when (count(u.id_usuario) > 0) then true else false end from Usuario u where u.email = :email and u.senha = :senha")
    Boolean validarLogin(@Param("email") String email, @Param("senha") String senha);
}
