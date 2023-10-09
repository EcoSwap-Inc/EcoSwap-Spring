package com.ecoswap.ecoswap.config;

import com.ecoswap.ecoswap.domain.Categoria;
import com.ecoswap.ecoswap.domain.Produto;
import com.ecoswap.ecoswap.domain.Usuario;
import com.ecoswap.ecoswap.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

// CLASSE DE TESTE PARA O H2
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private AvaliacaoRepository avaliacaoRepository;
    @Autowired
    private PropostaRepository propostaRepository;
    @Autowired
    private TrocaRepository trocaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;




    // TUDO QUE ESTIVER AQUI DENTRO VAI RODAR QUANDO A APLICAÇÃO INICIAR
    @Override
    public void run(String... args) throws Exception {

        Usuario u1 = new Usuario(null, "joaoadsistemas@gmail.com", "Joao", "Cerquilho", "SP", 18520029, "Achiles " +
                "Audi", 1054, "Casa");

        Usuario u2 = new Usuario(null, "lucas@gmail.com", "Lucas", "Tiete", "SP", 18522019, "Marte " +
                "Cico", 123, "Trabalho");

                usuarioRepository.saveAll(Arrays.asList(u1, u2));


        Categoria cat1 = new Categoria(null, "Livros");
        Categoria cat2 = new Categoria(null, "Smartphones");
        Categoria cat3 = new Categoria(null, "Notebook");

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        Produto p1 = new Produto(null, u1, cat1, "Senhor dos aneis");
        Produto p2 = new Produto(null, u2, cat3, "Mac Air m1");
        Produto p3 = new Produto(null, u1, cat2, "Galaxy s22");

        produtoRepository.saveAll(Arrays.asList(p1,p2,p3));

    }
}
