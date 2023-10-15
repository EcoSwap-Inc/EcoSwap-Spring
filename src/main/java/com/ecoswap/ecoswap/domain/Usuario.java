package com.ecoswap.ecoswap.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
@Table(name = "Usuarios")
public class Usuario implements Serializable {

    public Usuario() {
    }

    public Usuario(String email, String senha, String nome, String cidade, String UF, int cep, String rua, int numero_rua, String complemento) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.cidade = cidade;
        this.UF = UF;
        this.cep = cep;
        this.rua = rua;
        this.numero_rua = numero_rua;
        this.complemento = complemento;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    // Validação
    @NotNull
    @Email()
    @Size(max = 100)
    // JPA
    @Setter
    @Column(length = 100, nullable = false, unique = true)
    private String email;

    // Validação
    @NotNull
    @Size(max = 45)
    // JPA
    @Setter
    @Column(length = 45, nullable = false)
    private String senha;

    // Validação
    @NotNull
    @Size(max = 150)
    // JPA
    @Setter
    @Column(length = 150, nullable = false)
    private String nome;

    // Validação
    @NotNull
    @Size(max = 75)
    // JPA
    @Setter
    @Column(length = 75, nullable = false)
    private String cidade;

    // Validação
    @NotNull
    @Size(min = 2, max = 2)
    // JPA
    @Setter
    @Column(length = 2, nullable = false)
    private String UF;

    // Validação
    @NotNull
    @Size(max = 150)
    // JPA
    @Setter
    @Column(length = 150, nullable = false)
    private String rua;

    // Validação
    @Positive
    // JPA
    @Setter
    @Column()
    private int numero_rua;

    // Validação
    @Size(max = 100)
    // JPA
    @Setter
    @Column(length = 100)
    private String complemento;

    // Validação
    @NotNull
    // JPA
    @Setter
    @Column(nullable = false)
    private int cep;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Produto> produtosList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Troca> trocasList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Proposta> propostasList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "usuario_proposta")
    private List<Avaliacao> avaliacoesPropostasList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "usuario_troca")
    private List<Avaliacao> avaliacoesTrocasList = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id_usuario, usuario.id_usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_usuario);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id_usuario=" + id_usuario +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", UF='" + UF + '\'' +
                ", cep=" + cep +
                ", rua='" + rua + '\'' +
                ", numero_rua=" + numero_rua +
                ", complemento='" + complemento + '\'' +
                ", produtosList=" + produtosList +
                ", trocasList=" + trocasList +
                ", propostasList=" + propostasList +
                ", avaliacoesPropostasList=" + avaliacoesPropostasList +
                ", avaliacoesTrocasList=" + avaliacoesTrocasList +
                '}';
    }
}
