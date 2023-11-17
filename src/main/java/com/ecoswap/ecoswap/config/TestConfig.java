package com.ecoswap.ecoswap.config;

import com.ecoswap.ecoswap.domain.*;
import com.ecoswap.ecoswap.domain.users.Usuario;
import com.ecoswap.ecoswap.repository.*;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.awt.image.WritableRaster;
import java.util.Base64;

// CLASSE DE TESTE PARA O H2
@Configuration
@Transactional
// H2 SERVER @Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
//    @Autowired
//    private AvaliacaoRepository avaliacaoRepository;
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
        String imgComputador = "data:image/png;charset=utf-8;base64," + new String(Base64.getEncoder().encode(Files.readAllBytes(Paths.get("src/main/resources/imgs/teste.png"))), StandardCharsets.UTF_8);

        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        Usuario u1 = new Usuario("joaoadsistemas@gmail.com", b.encode("123"), "Joao", "Cerquilho", "SP", 18520029, "Achiles Audi", 1054, "Casa", null, "15997883239", LocalDate.parse("2005-10-10"));
        Usuario u2 = new Usuario("pedrohtejon@gmail.com", b.encode("pedro123"), "Pedro", "Sorocaba", "SP", 18016000, "Rua Tal", 34, "Casa", null, "15997883239", LocalDate.parse("2005-10-10"));
//        Usuario u2 = new Usuario("lucas@gmail.com", "123", "Lucas", "Tiete", "SP", 18522019, "Marte Cico", 123, "Trabalho", null, "15997883239", LocalDate.parse("2005-10-10"));
//        Usuario u3 = new Usuario("carlos@gmail.com", "123", "Carlos", "Sorocaba", "SP", 18522019, "Cicero Almeida", 1423, "Trabalho", null, "15997883239", LocalDate.parse("2005-10-10"));
//        Usuario u4 = new Usuario("roberto@gmail.com", "123", "Roberto", "Tatui", "SP", 129834, "Principal ", 654, "Trabalho", null, "15997883239", LocalDate.parse("2005-10-10"));
//        Usuario u5 = new Usuario("larissa@gmail.com", "123", "Larissa", "Boituva", "SP", 4019023, "Brasil ", 64, "Trabalho", null, "15997883239", LocalDate.parse("2005-10-10"));
//        Usuario u6 = new Usuario("ana@gmail.com", "123", "ana", "Rio De Janeiro", "RJ", 7539504, "Copa Copa", 123, "Trabalho", null, "15997883239", LocalDate.parse("2005-10-10"));
        usuarioRepository.saveAll(Arrays.asList(u1, u2));

        Categoria cat1 = new Categoria("Mídia");
        Categoria cat2 = new Categoria("Colecionáveis");
        Categoria cat3 = new Categoria("Jardinagem");
        Categoria cat4 = new Categoria("Livros e HQS");
        Categoria cat5 = new Categoria("Informática");
        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5));

        Produto p1 = new Produto(u1, cat4, "Senhor dos aneis", "", imgComputador);
        Produto p2 = new Produto(u2, cat5, "Mac Air m1", "", imgComputador);
        Produto p3 = new Produto(u2, cat2, "Galaxy s22", "", imgComputador);
        Produto p4 = new Produto(u1, cat5, "Nintendo 3ds", "", imgComputador);
        Produto p5 = new Produto(u1, cat2, "AirMax", "", imgComputador);
        Produto p6 = new Produto(u2, cat2, "Moletom", "", imgComputador);
        Produto p7 = new Produto(u1, cat2, "Onix 2022", "", imgComputador);
        Produto p8 = new Produto(u2, cat4, "Diário de um Banana 2: Rodrick é o Cara", "", imgComputador);
        Produto p9 = new Produto(u1, cat1, "Bee Movie", "", imgComputador);
        Produto p10 = new Produto(u2, cat3, "Pote de Jardinagem", "", imgComputador);
        Produto p11 = new Produto(u1, cat3, "Pote de Jardinagem", "", imgComputador);
        Produto p12 = new Produto(u2, cat3, "Pote de Jardinagem", "", imgComputador);
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12));

        Troca tr1 = new Troca(u1, p1, false,  null, null);
        Troca tr2 = new Troca(u2, p2, false,  null, null);
        Troca tr3 = new Troca(u2, p3, false,  null, null);
        Troca tr4 = new Troca(u1, p5, false,  null, null);
        Troca tr5 = new Troca(u2, p6, false,  null, null);
        trocaRepository.saveAll(Arrays.asList(tr1, tr2, tr3, tr4, tr5));

        Proposta prop1 = new Proposta(u1, tr5, p5, null, null, null);
        propostaRepository.save(prop1);

    }
}
