package com.ecoswap.ecoswap.config;

import com.ecoswap.ecoswap.services.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

// CLASSE DE TESTE PARA O H2
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;



    // TUDO QUE ESTIVER AQUI DENTRO VAI RODAR QUANDO A APLICAÇÃO INICIAR
    @Override
    public void run(String... args) throws Exception {

    }
}
