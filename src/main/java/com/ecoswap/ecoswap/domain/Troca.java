package com.ecoswap.ecoswap.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Trocas")
public class Troca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_troca;

    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name="id_produto")
    private Produto produto;

    @Column()
    private boolean finalizada;

    @Column(nullable = false)
    private LocalDateTime data_criacao;

    @Column()
    private LocalDateTime data_conclusao;
}
