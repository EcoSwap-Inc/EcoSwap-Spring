package com.ecoswap.ecoswap.domain.InputClasses;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;

@Validated
@Getter
public class AvaliacaoInput implements Serializable {

    public AvaliacaoInput() {
    }

    public AvaliacaoInput(Long usuario_proposta, Long usuario_troca, Long troca, Long proposta, double avaliacao_proposta, double avaliacao_troca) {
        this.usuario_proposta_id = usuario_proposta;
        this.usuario_troca_id = usuario_troca;
        this.troca_id = troca;
        this.proposta_id = proposta;
        this.avaliacao_proposta = avaliacao_proposta;
        this.avaliacao_troca = avaliacao_troca;
    }

    @Positive
    private Long troca_id;

    @Positive
    private Long proposta_id;

    @Positive
    private Long usuario_troca_id;

    @Positive
    private Long usuario_proposta_id;


    @PositiveOrZero
    @Max(5)
    private double avaliacao_troca;

    @PositiveOrZero
    @Max(5)
    private double avaliacao_proposta;
}
