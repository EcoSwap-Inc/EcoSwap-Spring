package com.ecoswap.ecoswap.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Entity
@Table(name = "Produtos")
public class Produto implements Serializable {

    public Produto() {
    }

    public Produto(Usuario usuario, Categoria categoria, String nome) {
        this.usuario = usuario;
        this.categoria = categoria;
        this.nome = nome;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_produto;

    @Setter
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Setter
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @Setter
    @Column(length = 45, nullable = false)
    private String nome;

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
                '}';
    }
}
