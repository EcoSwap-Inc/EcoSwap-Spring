package com.ecoswap.ecoswap.domain;

import jakarta.persistence.*;
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

    @Setter
    @OneToOne
    @JoinColumn(name = "id_troca")
    private Troca troca;

    @Setter
    @OneToOne
    @JoinColumn(name = "id_proposta")
    private Proposta proposta;

    @Setter
    @ManyToOne
    @JoinColumn(name = "id_usuario_troca")
    private Usuario usuario_troca;

    @Setter
    @ManyToOne
    @JoinColumn(name = "id_usuario_proposta")
    private Usuario usuario_proposta;

    @Setter
    @Column()
    private double avaliacao_troca;

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
