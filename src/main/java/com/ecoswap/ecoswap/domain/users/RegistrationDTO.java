package com.ecoswap.ecoswap.domain.users;

public record RegistrationDTO(String email, String senha, String nome, String cidade, String uf, String rua, int cep) {
}
