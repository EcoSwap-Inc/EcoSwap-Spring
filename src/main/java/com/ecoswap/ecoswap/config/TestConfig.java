package com.ecoswap.ecoswap.config;

import com.ecoswap.ecoswap.domain.*;
import com.ecoswap.ecoswap.domain.users.Usuario;
import com.ecoswap.ecoswap.repository.*;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;
import java.util.Arrays;

// CLASSE DE TESTE PARA O H2
@Configuration
@Transactional
// H2 SERVER @Profile("test")
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

    private EntityManager entityManager;

    // TUDO QUE ESTIVER AQUI DENTRO VAI RODAR QUANDO A APLICAÇÃO INICIAR
    @Override
    public void run(String... args) throws Exception {

        Usuario u1 = new Usuario("joaoadsistemas@gmail.com", "123", "Joao", "Cerquilho", "SP", 18520029, "Achiles Audi", 1054, "Casa");
        Usuario u2 = new Usuario("lucas@gmail.com", "123", "Lucas", "Tiete", "SP", 18522019, "Marte Cico", 123, "Trabalho");
        Usuario u3 = new Usuario("carlos@gmail.com", "123", "Carlos", "Sorocaba", "SP", 18522019, "Cicero Almeida", 1423, "Trabalho");
        Usuario u4 = new Usuario("roberto@gmail.com", "123", "Roberto", "Tatui", "SP", 129834, "Principal ", 654, "Trabalho");
        Usuario u5 = new Usuario("larissa@gmail.com", "123", "Larissa", "Boituva", "SP", 4019023, "Brasil ", 64, "Trabalho");
        Usuario u6 = new Usuario("ana@gmail.com", "123", "ana", "Rio De Janeiro", "RJ", 7539504, "Copa Copa", 123, "Trabalho");
        usuarioRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5, u6));

        Categoria cat1 = new Categoria("Livros");
        Categoria cat2 = new Categoria("Smartphones");
        Categoria cat3 = new Categoria("Notebooks");
        Categoria cat4 = new Categoria("Carros");
        Categoria cat5 = new Categoria("Roupas");
        Categoria cat6 = new Categoria("Tenis");
        Categoria cat7 = new Categoria("Eletronicos");
        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));

        Produto p1 = new Produto(u1, cat1, "Senhor dos aneis");
        Produto p2 = new Produto(u2, cat3, "Mac Air m1");
        Produto p3 = new Produto(u3, cat2, "Galaxy s22");
        Produto p4 = new Produto(u5, cat7, "Nintendo 3ds");
        Produto p5 = new Produto(u1, cat6, "AirMax");
        Produto p6 = new Produto(u4, cat5, "Moletom");
        Produto p7 = new Produto(u6, cat4, "Onix 2022");
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7));

        Troca tr1 = new Troca(u1, p1, false, LocalDateTime.now(), LocalDateTime.now(), null);
        Troca tr2 = new Troca(u2, p2, true, LocalDateTime.now(), LocalDateTime.now(), null);
        Troca tr3 = new Troca(u3, p3, true, LocalDateTime.now(), LocalDateTime.now(), null);
        Troca tr4 = new Troca(u6, p5, false, LocalDateTime.now(), LocalDateTime.now(), null);
        Troca tr5 = new Troca(u5, p6, false, LocalDateTime.now(), LocalDateTime.now(), null);
        trocaRepository.saveAll(Arrays.asList(tr1, tr2, tr3, tr4, tr5));

        Proposta prop1 = new Proposta(u1, tr1, p2, true, LocalDateTime.now(), LocalDateTime.now(), null);
        Proposta prop2 = new Proposta(u2, tr2, p4, true, LocalDateTime.now(), LocalDateTime.now(), null);
        Proposta prop3 = new Proposta(u3, tr3, p3, true, LocalDateTime.now(), LocalDateTime.now(), null);
        Proposta prop4 = new Proposta(u5, tr5, p5, true, LocalDateTime.now(), LocalDateTime.now(), null);
        Proposta prop5 = new Proposta(u4, tr2, p1, true, LocalDateTime.now(), LocalDateTime.now(), null);
        propostaRepository.saveAll(Arrays.asList(prop1, prop2, prop3, prop4, prop5));

        Avaliacao av1 = new Avaliacao(u1, u2, tr1, prop1, 3.5, 5);
        Avaliacao av2 = new Avaliacao(u3, u4, tr2, prop2, 2, 5);
        Avaliacao av3 = new Avaliacao(u5, u6, tr5, prop4, 1, 2);
        avaliacaoRepository.saveAll(Arrays.asList(av1, av2, av3));
    }
}
