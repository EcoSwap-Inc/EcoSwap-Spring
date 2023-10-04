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
@Table(name="Avaliacoes")
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_avaliacao;

    @OneToOne
    @JoinColumn(name="id_usuario_proposta")
    private Usuario usuario_proposta;

    @OneToOne
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
