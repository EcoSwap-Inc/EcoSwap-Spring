package com.ecoswap.ecoswap.domain.users;

import com.ecoswap.ecoswap.domain.Avaliacao;
import com.ecoswap.ecoswap.domain.Produto;
import com.ecoswap.ecoswap.domain.Proposta;
import com.ecoswap.ecoswap.domain.Troca;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Validated
@Getter
@Entity
@Table(name = "Usuarios")
public class Usuario implements UserDetails, Serializable {

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
    // JPA
    @Setter
    @Column(nullable = false)
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
    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    private List<Produto> produtosList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    private List<Troca> trocasList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    private List<Proposta> propostasList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "usuario_proposta", fetch = FetchType.EAGER)
    private List<Avaliacao> avaliacoesPropostasList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "usuario_troca", fetch = FetchType.EAGER)
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));

    }

    @Override
    public String getPassword() {
        return getSenha();
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
