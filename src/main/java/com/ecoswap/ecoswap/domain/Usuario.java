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
@Table(name="Usuarios")
public class Usuario implements Serializable {

    public Usuario() {
    }

    public Usuario(Long id_usuario, String email, String nome, String cidade, String UF, int cep, String rua, int numero_rua, String complemento) {
        this.id_usuario = id_usuario;
        this.email = email;
        this.nome = nome;
        this.cidade = cidade;
        this.UF = UF;
        this.cep = cep;
        this.rua = rua;
        this.numero_rua = numero_rua;
        this.complemento = complemento;
    }

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @Getter
    @Column(length = 45, nullable = false, unique = true)
    private String email;

    @Getter
    @Column(length = 45, nullable = false)
    private String nome;

    @Getter
    @Column(length = 45, nullable = false)
    private String cidade;

    @Getter
    @Column(length = 2, nullable = false)
    private String UF;

    @Getter
    @Column(nullable = false)
    private int cep;

    @Getter
    @Column(length = 45, nullable = false)
    private String rua;

    @Getter
    @Column(nullable = false)
    private int numero_rua;

    @Getter
    @Column(length = 45)
    private String complemento;

    @JsonIgnore
    @OneToMany(mappedBy="usuario")
    private List<Produto> produtosList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy="usuario")
    private List<Troca> trocasList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy="usuario")
    private List<Proposta> propostasList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy="usuario_proposta")
    private List<Avaliacao> avaliacoesPropostasList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy="usuario_troca")
    private List<Avaliacao> avaliacoesTrocasList = new ArrayList<>();

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero_rua(int numero_rua) {
        this.numero_rua = numero_rua;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public List<Produto> getProdutosList() {
        return produtosList;
    }

    public List<Troca> getTrocasList() {
        return trocasList;
    }

    public List<Proposta> getPropostasList() {
        return propostasList;
    }

    public List<Avaliacao> getAvaliacoesPropostasList() {
        return avaliacoesPropostasList;
    }

    public List<Avaliacao> getAvaliacoesTrocasList() {
        return avaliacoesTrocasList;
    }

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
