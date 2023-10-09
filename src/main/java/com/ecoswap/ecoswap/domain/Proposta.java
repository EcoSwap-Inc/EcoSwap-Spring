package com.ecoswap.ecoswap.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Propostas")
public class Proposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_proposta;

    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="id_troca")
    private Troca troca;

    @OneToOne
    @JoinColumn(name="id_produto")
    private Produto produto;

    @Column(nullable = false)
    private boolean aceito;

    @Column(nullable = false)
    private LocalDateTime data_criacao;

    @Column()
    private LocalDateTime data_conclusao;

    @JsonIgnore
    @OneToOne
    private Avaliacao avaliacao;
}
