package com.ecoswap.ecoswap.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;


@Entity
@Table(name="Avaliacoes")
public class Avaliacao implements Serializable {

    public Avaliacao() {
    }

    public Avaliacao(Long id_avaliacao, Usuario usuario_proposta, Usuario usuario_troca, Troca troca, double avaliacao_proposta, double avaliacao_troca) {
        this.id_avaliacao = id_avaliacao;
        this.usuario_proposta = usuario_proposta;
        this.usuario_troca = usuario_troca;
        this.troca = troca;
        this.avaliacao_proposta = avaliacao_proposta;
        this.avaliacao_troca = avaliacao_troca;
    }

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
    @JoinColumn(name="id_troca")
    private Troca troca;

    @Column()
    private double avaliacao_proposta;

    @Column()
    private double avaliacao_troca;

    public Long getId_avaliacao() {
        return id_avaliacao;
    }

    public void setId_avaliacao(Long id_avaliacao) {
        this.id_avaliacao = id_avaliacao;
    }

    public Usuario getUsuario_proposta() {
        return usuario_proposta;
    }

    public void setUsuario_proposta(Usuario usuario_proposta) {
        this.usuario_proposta = usuario_proposta;
    }

    public Usuario getUsuario_troca() {
        return usuario_troca;
    }

    public void setUsuario_troca(Usuario usuario_troca) {
        this.usuario_troca = usuario_troca;
    }




    public Troca getTroca() {
        return troca;
    }

    public void setTroca(Troca troca) {
        this.troca = troca;
    }

    public double getAvaliacao_proposta() {
        return avaliacao_proposta;
    }

    public void setAvaliacao_proposta(double avaliacao_proposta) {
        this.avaliacao_proposta = avaliacao_proposta;
    }

    public double getAvaliacao_troca() {
        return avaliacao_troca;
    }

    public void setAvaliacao_troca(double avaliacao_troca) {
        this.avaliacao_troca = avaliacao_troca;
    }

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
                ", avaliacao_proposta=" + avaliacao_proposta +
                ", avaliacao_troca=" + avaliacao_troca +
                '}';
    }
}
