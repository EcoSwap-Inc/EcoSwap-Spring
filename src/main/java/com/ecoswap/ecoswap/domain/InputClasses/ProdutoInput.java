package com.ecoswap.ecoswap.domain.InputClasses;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;

@Validated
@Getter
public class ProdutoInput implements Serializable {

    public ProdutoInput() {
    }

    public ProdutoInput(Long usuario, Long categoria, String nome, String descricao, byte[] imagem) {
        this.usuario_id = usuario;
        this.categoria_id = categoria;
        this.nome = nome;
        this.imagem = imagem;
        this.descricao = descricao;
    }

    @Positive
    private Long usuario_id;

    @Positive
    private Long categoria_id;

    @Size(min = 5, max = 150)
    private String nome;

    @Size(max=500)
    private String descricao;

    @Lob
    private byte[] imagem;
}
