package com.ecoswap.ecoswap.config;

import com.ecoswap.ecoswap.domain.*;
import com.ecoswap.ecoswap.services.*;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

// CLASSE DE TESTE PARA O H2
@Configuration
@Transactional
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

    private EntityManager entityManager;



    // TUDO QUE ESTIVER AQUI DENTRO VAI RODAR QUANDO A APLICAÇÃO INICIAR
    @Override
    public void run(String... args) throws Exception {

        Usuario u1 = new Usuario(null, "joaoadsistemas@gmail.com", "Joao", "Cerquilho", "SP", 18520029, "Achiles " +
                "Audi", 1054, "Casa");

        Usuario u2 = new Usuario(null, "lucas@gmail.com", "Lucas", "Tiete", "SP", 18522019, "Marte " +
                "Cico", 123, "Trabalho");
        Usuario u3 = new Usuario(null, "carlos@gmail.com", "Carlos", "Sorocaba", "SP", 18522019, "Cicero " +
                "Almeida", 1423, "Trabalho");
        Usuario u4 = new Usuario(null, "roberto@gmail.com", "Roberto", "Tatui", "SP", 129834, "Principal "
                , 654, "Trabalho");
        Usuario u5 = new Usuario(null, "larissa@gmail.com", "Larissa", "Boituva", "SP", 4019023, "Brasil "
            , 64, "Trabalho");
        Usuario u6 = new Usuario(null, "ana@gmail.com", "ana", "Rio De Janeiro", "RJ", 7539504, "Copa " +
                "Copa", 123, "Trabalho");

                usuarioRepository.saveAll(Arrays.asList(u1, u2,u3,u4,u5,u6));


        Categoria cat1 = new Categoria(null, "Livros");
        Categoria cat2 = new Categoria(null, "Smartphones");
        Categoria cat3 = new Categoria(null, "Notebooks");
        Categoria cat4 = new Categoria(null, "Carros");
        Categoria cat5 = new Categoria(null, "Roupas");
        Categoria cat6 = new Categoria(null, "Tenis");
        Categoria cat7 = new Categoria(null, "Eletronicos");

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3,cat4,cat5,cat6,cat7));

        Produto p1 = new Produto(null, u1, cat1, "Senhor dos aneis");
        Produto p2 = new Produto(null, u2, cat3, "Mac Air m1");
        Produto p3 = new Produto(null, u3, cat2, "Galaxy s22");
        Produto p4 = new Produto(null, u5, cat7, "Nintendo 3ds");
        Produto p5 = new Produto(null, u1, cat6, "AirMax");
        Produto p6 = new Produto(null, u4, cat5, "Moletom");
        Produto p7 = new Produto(null, u6, cat4, "Onix 2022");

        produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7));

        Troca tr1 = new Troca(null, u1, p1, false, LocalDateTime.now(), LocalDateTime.now(), null);
        Troca tr2 = new Troca(null, u2, p2, true, LocalDateTime.now(), LocalDateTime.now(), null);
        Troca tr3 = new Troca(null, u3, p3, true, LocalDateTime.now(), LocalDateTime.now(), null);
        Troca tr4 = new Troca(null, u6, p5, false, LocalDateTime.now(), LocalDateTime.now(), null);
        Troca tr5 = new Troca(null, u5, p6, false, LocalDateTime.now(), LocalDateTime.now(), null);


        trocaRepository.saveAll(Arrays.asList(tr1,tr2,tr3,tr4,tr5));



        Proposta prop1 = new Proposta(u1, tr1, p2, true, LocalDateTime.now(), LocalDateTime.now());
        Proposta prop2 = new Proposta(u2,tr2,p4,true,LocalDateTime.now(), LocalDateTime.now());
        Proposta prop3 = new Proposta(u3,tr3,p3,true,LocalDateTime.now(), LocalDateTime.now());
        Proposta prop4 = new Proposta(u5,tr5,p5,true,LocalDateTime.now(), LocalDateTime.now());
        Proposta prop5 = new Proposta(u4,tr2,p1,true,LocalDateTime.now(), LocalDateTime.now());

        propostaRepository.saveAll(Arrays.asList(prop1,prop2,prop3,prop4,prop5));

        /// ERRO ACONTECE NA CLASSE AVALIACAO

        Avaliacao av1 = new Avaliacao(null, u1, u2, tr1, 5, 5);
        Avaliacao av2 = new Avaliacao(null, u3, u4, tr2, 7, 5);
        Avaliacao av3 = new Avaliacao(null, u5, u6, tr5, 1, 2);

        avaliacaoRepository.saveAll(Arrays.asList(av1,av2,av3));

    }
}
