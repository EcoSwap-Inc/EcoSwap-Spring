package com.ecoswap.ecoswap.domain.InputClasses;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;

@Validated
@Getter
public class CategoriaInput implements Serializable {

    public CategoriaInput() {
    }

    public CategoriaInput(String nome) {
        this.nome = nome;
    }

    @Size(min = 3, max = 100)
    private String nome;
}
