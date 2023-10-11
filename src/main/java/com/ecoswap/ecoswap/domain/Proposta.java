package com.ecoswap.ecoswap.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Table(name = "Propostas")
public class Proposta implements Serializable {

    public Proposta() {
    }

    public Proposta(Usuario usuario, Troca troca, Produto produto, boolean aceito, LocalDateTime data_criacao, LocalDateTime data_conclusao, Avaliacao avaliacao) {
        this.usuario = usuario;
        this.troca = troca;
        this.produto = produto;
        this.aceito = aceito;
        this.data_criacao = data_criacao;
        this.data_conclusao = data_conclusao;
        this.avaliacao = avaliacao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_proposta;

    @Setter
    @ManyToOne
    @JoinColumn(name = "id_troca")
    private Troca troca;

    @Setter
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @Setter
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Setter
    @Column(nullable = false)
    private boolean aceito;

    @Setter
    @Column(nullable = false)
    private LocalDateTime data_criacao;

    @Setter
    @Column()
    private LocalDateTime data_conclusao;

    @Setter
    @JsonIgnore
    @OneToOne(mappedBy = "proposta")
    private Avaliacao avaliacao;

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
                ", avaliacao=" + avaliacao +
                '}';
    }
}
