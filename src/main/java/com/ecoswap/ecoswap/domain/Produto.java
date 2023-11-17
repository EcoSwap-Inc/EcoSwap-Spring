package com.ecoswap.ecoswap.domain;

import com.ecoswap.ecoswap.domain.users.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Validated
@Getter
@Entity
@Table(name = "Produtos")
public class Produto implements Serializable {

    public Produto() {
    }

    public Produto(Usuario usuario, Categoria categoria, String nome, String descricao, String imagem) {
        this.usuario = usuario;
        this.categoria = categoria;
        this.nome = nome;
        this.imagem = imagem;
        this.descricao = descricao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    // Validação
    @Size(max = 500)
    // JPA
    @Setter
    @Column(length = 500, nullable = false)
    private String descricao;

    @Lob
    @Setter
    @Column (name = "imagem")
    private String imagem;

    @Column(name = "dataCriada", updatable = false)
    private Instant dataCriada = Instant.now();

    @Setter
    private Long views = 0L;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id_produto=" + id +
                ", usuario=" + usuario +
                ", categoria=" + categoria +
                ", nome='" + nome + '\'' +
                '}';
    }
}
