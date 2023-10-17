package com.ecoswap.ecoswap.domain.users;

public record ModelUsuarioDTO(String nome, String cidade, String UF, int cep, String rua, int numero_rua,
                              String complemento) {
}
