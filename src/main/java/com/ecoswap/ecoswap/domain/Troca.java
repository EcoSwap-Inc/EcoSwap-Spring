package com.ecoswap.ecoswap.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Getter
@Entity
@Table(name = "Trocas")
public class Troca implements Serializable {

    public Troca() {
    }

    public Troca(Usuario usuario, Produto produto, boolean finalizada, LocalDateTime data_criacao, LocalDateTime data_conclusao, Avaliacao avaliacao) {
        this.usuario = usuario;
        this.produto = produto;
        this.finalizada = finalizada;
        this.data_criacao = data_criacao;
        this.data_conclusao = data_conclusao;
        this.avaliacao = avaliacao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_troca;

    // Validação
    @Valid
    @NotNull
    // JPA
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto produto;

    // Validação
    @Valid
    @NotNull
    // JPA
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    // Validação
    @NotNull
    // JPA
    @Setter
    @Column(nullable = false)
    private boolean finalizada;

    // Validação
    @NotNull
    // JPA
    @Setter
    @Column(nullable = false)
    private LocalDateTime data_criacao;

    // Validação
    // JPA
    @Setter
    @Column()
    private LocalDateTime data_conclusao;

    // Validação
    @Valid
    // JPA
    @Setter
    @JsonIgnore
    @OneToOne(mappedBy = "troca")
    private Avaliacao avaliacao;

    @JsonIgnore
    @OneToMany(mappedBy = "troca")
    private List<Proposta> propostasList = new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Troca troca = (Troca) o;
        return Objects.equals(id_troca, troca.id_troca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_troca);
    }

    @Override
    public String toString() {
        return "Troca{" +
                "id_troca=" + id_troca +
                ", usuario=" + usuario +
                ", produto=" + produto +
                ", finalizada=" + finalizada +
                ", data_criacao=" + data_criacao +
                ", data_conclusao=" + data_conclusao +
                ", avaliacao=" + avaliacao +
                ", propostasList=" + propostasList +
                '}';
    }
}
