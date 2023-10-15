package com.ecoswap.ecoswap.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Validated
@Getter
@Entity
@Table(name = "Categorias")
public class Categoria implements Serializable {

    public Categoria() {
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categoria;

    // Validação
    @NotNull
    @Size(min = 3, max = 100)
    // JPA
    @Setter
    @Column(length = 100, nullable = false)
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "categoria")
    private List<Produto> produtosList = new ArrayList<>();

    public void setProdutosList(List<Produto> produtosList) {
        this.produtosList = produtosList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(id_categoria, categoria.id_categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_categoria);
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id_categoria=" + id_categoria +
                ", nome='" + nome + '\'' +
                ", produtosList=" + produtosList +
                '}';
    }
}
