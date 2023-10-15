package com.ecoswap.ecoswap.domain;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Entity
@Table(name = "Avaliacoes")
public class Avaliacao implements Serializable {

    public Avaliacao() {
    }

    public Avaliacao(Usuario usuario_proposta, Usuario usuario_troca, Troca troca, Proposta proposta, double avaliacao_proposta, double avaliacao_troca) {
        this.usuario_proposta = usuario_proposta;
        this.usuario_troca = usuario_troca;
        this.troca = troca;
        this.proposta = proposta;
        this.avaliacao_proposta = avaliacao_proposta;
        this.avaliacao_troca = avaliacao_troca;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_avaliacao;

    // Validação
    @Valid
    @NotNull
    // JPA
    @Setter
    @OneToOne
    @JoinColumn(name = "id_troca", nullable = false)
    private Troca troca;

    // Validação
    @Valid
    @NotNull
    // JPA
    @Setter
    @OneToOne
    @JoinColumn(name = "id_proposta", nullable = false)
    private Proposta proposta;

    // Validação
    @Valid
    @NotNull
    // JPA
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_usuario_troca", nullable = false)
    private Usuario usuario_troca;

    // Validação
    @Valid
    @NotNull
    // JPA
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_usuario_proposta", nullable = false)
    private Usuario usuario_proposta;

    // Validação
    @PositiveOrZero
    @Max(5)
    // JPA
    @Setter
    @Column()
    private double avaliacao_troca;

    // Validação
    @PositiveOrZero
    @Max(5)
    // JPA
    @Setter
    @Column()
    private double avaliacao_proposta;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avaliacao avaliacao = (Avaliacao) o;
        return Objects.equals(id_avaliacao, avaliacao.id_avaliacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_avaliacao);
    }

    @Override
    public String toString() {
        return "Avaliacao{" +
                "id_avaliacao=" + id_avaliacao +
                ", usuario_proposta=" + usuario_proposta +
                ", usuario_troca=" + usuario_troca +
                ", troca=" + troca +
                ", proposta=" + proposta +
                ", avaliacao_proposta=" + avaliacao_proposta +
                ", avaliacao_troca=" + avaliacao_troca +
                '}';
    }
}
