package com.ecoswap.ecoswap.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name="Produtos")
public class Produto implements Serializable {

    public Produto() {
    }

    public Produto(Long id_produto, Usuario usuario, Categoria categoria, String nome) {
        this.id_produto = id_produto;
        this.usuario = usuario;
        this.categoria = categoria;
        this.nome = nome;
    }

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_produto;

    @Getter
    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    @Getter
    @ManyToOne
    @JoinColumn(name="id_categoria")
    private Categoria categoria;

    @Getter
    @Column(length = 45, nullable = false)
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy="produto")
    private List<Troca> trocasList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy="produto")
    private List<Troca> propostasList = new ArrayList<>();

    public void setId_produto(Long id_produto) {
        this.id_produto = id_produto;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Troca> getTrocasList() {
        return trocasList;
    }

    public List<Troca> getPropostasList() {
        return propostasList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id_produto, produto.id_produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_produto);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id_produto=" + id_produto +
                ", usuario=" + usuario +
                ", categoria=" + categoria +
                ", nome='" + nome + '\'' +
                ", trocasList=" + trocasList +
                ", propostasList=" + propostasList +
                '}';
    }
}
