package com.ecoswap.ecoswap.domain;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.Objects;

@Validated
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

    // Validação
    @Valid
    @NotNull
    // JPA
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    // Validação
    @Valid
    @NotNull
    // JPA
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    // Validação
    @NotNull
    @Size(min = 5, max = 150)
    // JPA
    @Setter
    @Column(length = 150, nullable = false)
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
