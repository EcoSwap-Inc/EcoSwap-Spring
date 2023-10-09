package com.ecoswap.ecoswap.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Trocas")
public class Troca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_troca;

    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="id_produto")
    private Produto produto;

    @Column()
    private boolean finalizada;

    @Column(nullable = false)
    private LocalDateTime data_criacao;

    @Column()
    private LocalDateTime data_conclusao;

    @JsonIgnore
    @OneToOne
    private Avaliacao avaliacao;

    @JsonIgnore
    @OneToMany
    private List<Avaliacao> propostasList = new ArrayList<>();
}
