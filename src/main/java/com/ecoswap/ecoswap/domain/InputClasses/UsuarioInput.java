package com.ecoswap.ecoswap.domain.InputClasses;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;

@Validated
@Getter
public class UsuarioInput implements Serializable {

    public UsuarioInput() {
    }

    public UsuarioInput(String email, String senha, String nome, String cidade, String UF, int cep, String rua, int numero_rua, String complemento) {
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

    @Positive
    private int numero_rua;

    @Size(max = 100)
    private String complemento;

    private int cep;
}
