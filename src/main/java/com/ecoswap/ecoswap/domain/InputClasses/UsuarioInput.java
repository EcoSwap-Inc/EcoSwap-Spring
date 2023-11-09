package com.ecoswap.ecoswap.domain.InputClasses;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.time.LocalDate;

@Validated
@Getter
public class UsuarioInput implements Serializable {

    public UsuarioInput() {
    }

    public UsuarioInput(String email, String senha, String nome, String cidade, String UF, int cep, String rua, int numero_rua, String complemento, byte[] imagem, int telefone, LocalDate dataNasc) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.cidade = cidade;
        this.UF = UF;
        this.cep = cep;
        this.rua = rua;
        this.numero_rua = numero_rua;
        this.complemento = complemento;
        this.imagem = imagem;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
    }

    @Email()
    @Size(max = 100)
    private String email;

    @Size(max = 45)
    private String senha;

    @Size(max = 150)
    private String nome;

    @Size(max = 75)
    private String cidade;

    @Size(min = 2, max = 2)
    private String UF;

    @Size(max = 150)
    private String rua;

    @PositiveOrZero
    private int numero_rua;

    @Size(max = 100)
    private String complemento;

    @Lob
    private byte[] imagem;

    private LocalDate dataNasc;

    private int telefone;

    private int cep;
}
