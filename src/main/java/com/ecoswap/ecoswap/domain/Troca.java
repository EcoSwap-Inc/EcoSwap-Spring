package com.ecoswap.ecoswap.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name="Trocas")
public class Troca implements Serializable {

    public Troca() {
    }

    public Troca(Long id_troca, Usuario usuario, Produto produto, boolean finalizada, LocalDateTime data_criacao, LocalDateTime data_conclusao, Avaliacao avaliacao) {
        this.id_troca = id_troca;
        this.usuario = usuario;
        this.produto = produto;
        this.finalizada = finalizada;
        this.data_criacao = data_criacao;
        this.data_conclusao = data_conclusao;
        this.avaliacao = avaliacao;
    }

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_troca;

    @Getter
    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    @Getter
    @ManyToOne
    @JoinColumn(name="id_produto")
    private Produto produto;

    @Getter
    @Column()
    private boolean finalizada;

    @Getter
    @Column(nullable = false)
    private LocalDateTime data_criacao;

    @Getter
    @Column()
    private LocalDateTime data_conclusao;

    @Getter
    @JsonIgnore
    @OneToOne(mappedBy = "troca")
    private Avaliacao avaliacao;

    @JsonIgnore
    @OneToMany
    private List<Avaliacao> propostasList = new ArrayList<>();

    public void setId_troca(Long id_troca) {
        this.id_troca = id_troca;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public void setData_criacao(LocalDateTime data_criacao) {
        this.data_criacao = data_criacao;
    }

    public void setData_conclusao(LocalDateTime data_conclusao) {
        this.data_conclusao = data_conclusao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public List<Avaliacao> getPropostasList() {
        return propostasList;
    }

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
