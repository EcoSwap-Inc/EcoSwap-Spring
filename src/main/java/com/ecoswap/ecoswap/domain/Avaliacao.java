package com.ecoswap.ecoswap.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Avaliacoes")
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_avaliacao;

    @ManyToOne
    @JoinColumn(name="id_usuario_proposta")
    private Usuario usuario_proposta;

    @ManyToOne
    @JoinColumn(name="id_usuario_troca")
    private Usuario usuario_troca;

    @OneToOne
    @JoinColumn(name="id_proposta")
    private Proposta proposta;

    @OneToOne
    @JoinColumn(name="id_troca")
    private Troca troca;

    @Column()
    private double avaliacao_proposta;

    @Column()
    private double avaliacao_troca;
}
