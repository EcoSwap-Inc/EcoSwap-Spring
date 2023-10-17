package com.ecoswap.ecoswap.domain.users;

import org.springframework.stereotype.Component;

public record ModelUsuarioDTO(String nome, String cidade, String UF, int cep, String rua, int numero_rua, String complemento) {
}
