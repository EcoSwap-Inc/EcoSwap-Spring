package com.ecoswap.ecoswap.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @Column(length = 45, nullable = false, unique = true)
    private String email;

    @Column(length = 45, nullable = false)
    private String nome;

    @Column(length = 45, nullable = false)
    private String cidade;

    @Column(length = 2, nullable = false)
    private String UF;

    @Column(nullable = false)
    private int cep;

    @Column(length = 45, nullable = false)
    private String rua;

    @Column(nullable = false)
    private int numero_rua;

    @Column(length = 45)
    private String complemento;

    @OneToMany
}
