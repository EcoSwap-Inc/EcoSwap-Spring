package com.ecoswap.ecoswap.domain.InputClasses;

import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Validated
@Getter
public class TrocaInput implements Serializable {

    public TrocaInput() {
    }

    public TrocaInput(Long usuario, Long produto, boolean finalizada, LocalDateTime data_conclusao, Long avaliacao) {
        this.usuario_id = usuario;
        this.produto_id = produto;
        this.finalizada = finalizada;
        this.data_conclusao = data_conclusao;
        this.avaliacao_id = avaliacao;
    }

    @Positive
    private Long produto_id;

    @Positive
    private Long usuario_id;

    private boolean finalizada;

    private LocalDateTime data_conclusao;

    @Positive
    private Long avaliacao_id;

    @Setter
    private Long views = 0L;
}
