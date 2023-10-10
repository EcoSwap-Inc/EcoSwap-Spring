package com.ecoswap.ecoswap.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name="Propostas")
public class Proposta implements Serializable {

    public Proposta() {
    }

    public Proposta( Usuario usuario, Troca troca, Produto produto, boolean aceito, LocalDateTime data_criacao, LocalDateTime data_conclusao) {
        this.usuario = usuario;
        this.troca = troca;
        this.produto = produto;
        this.aceito = aceito;
        this.data_criacao = data_criacao;
        this.data_conclusao = data_conclusao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_proposta;

    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="id_troca")
    private Troca troca;

    @ManyToOne
    @JoinColumn(name="id_produto")
    private Produto produto;

    @Column(nullable = false)
    private boolean aceito;

    @Column(nullable = false)
    private LocalDateTime data_criacao;

    @Column()
    private LocalDateTime data_conclusao;


    public Long getId_proposta() {
        return id_proposta;
    }

    public void setId_proposta(Long id_proposta) {
        this.id_proposta = id_proposta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Troca getTroca() {
        return troca;
    }

    public void setTroca(Troca troca) {
        this.troca = troca;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public boolean isAceito() {
        return aceito;
    }

    public void setAceito(boolean aceito) {
        this.aceito = aceito;
    }

    public LocalDateTime getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(LocalDateTime data_criacao) {
        this.data_criacao = data_criacao;
    }

    public LocalDateTime getData_conclusao() {
        return data_conclusao;
    }

    public void setData_conclusao(LocalDateTime data_conclusao) {
        this.data_conclusao = data_conclusao;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proposta proposta = (Proposta) o;
        return Objects.equals(id_proposta, proposta.id_proposta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_proposta);
    }

    @Override
    public String toString() {
        return "Proposta{" +
                "id_proposta=" + id_proposta +
                ", usuario=" + usuario +
                ", troca=" + troca +
                ", produto=" + produto +
                ", aceito=" + aceito +
                ", data_criacao=" + data_criacao +
                ", data_conclusao=" + data_conclusao +

                '}';
    }
}
