package com.ecoswap.ecoswap.domain.InputClasses;

import jakarta.validation.constraints.Positive;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.time.LocalDateTime;

@Validated
@Getter
public class PropostaInput implements Serializable {

    public PropostaInput() {
    }

    public PropostaInput(Long usuario, Long troca, Long produto, Boolean aceito, LocalDateTime data_criacao, LocalDateTime data_conclusao, Long avaliacao) {
        this.usuario_id = usuario;
        this.troca_id = troca;
        this.produto_id = produto;
        this.aceito = aceito;
        this.data_criacao = data_criacao;
        this.data_conclusao = data_conclusao;
        this.avaliacao_id = avaliacao;
    }

    @Positive
    private Long troca_id;

    @Positive
    private Long produto_id;

    @Positive
    private Long usuario_id;

    private Boolean aceito;

    private LocalDateTime data_criacao;

    private LocalDateTime data_conclusao;

    @Positive
    private Long avaliacao_id;
}
