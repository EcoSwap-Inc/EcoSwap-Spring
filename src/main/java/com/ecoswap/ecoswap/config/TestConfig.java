package com.ecoswap.ecoswap.config;

import com.ecoswap.ecoswap.domain.Categoria;
import com.ecoswap.ecoswap.domain.Produto;
import com.ecoswap.ecoswap.domain.Proposta;
import com.ecoswap.ecoswap.domain.Troca;
import com.ecoswap.ecoswap.domain.users.Usuario;
import com.ecoswap.ecoswap.repository.*;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
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
        String imgNintendo = "data:image/png;charset=utf-8;base64," + new String(Base64.getEncoder().encode(Files.readAllBytes(Paths.get("src/main/resources/imgs/nintendo.png"))), StandardCharsets.UTF_8);
        String imgPote = "data:image/jpeg;charset=utf-8;base64," + new String(Base64.getEncoder().encode(Files.readAllBytes(Paths.get("src/main/resources/imgs/pote.jpeg"))), StandardCharsets.UTF_8);
        String imgSenhor = "data:image/jpeg;charset=utf-8;base64," + new String(Base64.getEncoder().encode(Files.readAllBytes(Paths.get("src/main/resources/imgs/senhor.jpg"))), StandardCharsets.UTF_8);
        String imgAirmax = "data:image/jpeg;charset=utf-8;base64," + new String(Base64.getEncoder().encode(Files.readAllBytes(Paths.get("src/main/resources/imgs/airmax.jpeg"))), StandardCharsets.UTF_8);
        String imgMoletom = "data:image/jpeg;charset=utf-8;base64," + new String(Base64.getEncoder().encode(Files.readAllBytes(Paths.get("src/main/resources/imgs/moletom.jpeg"))), StandardCharsets.UTF_8);
        String imgMac = "data:image/jpeg;charset=utf-8;base64," + new String(Base64.getEncoder().encode(Files.readAllBytes(Paths.get("src/main/resources/imgs/mac.jpeg"))), StandardCharsets.UTF_8);
        String imgGalaxy = "data:image/jpeg;charset=utf-8;base64," + new String(Base64.getEncoder().encode(Files.readAllBytes(Paths.get("src/main/resources/imgs/galaxy.jpeg"))), StandardCharsets.UTF_8);
        String imgBee = "data:image/jpeg;charset=utf-8;base64," + new String(Base64.getEncoder().encode(Files.readAllBytes(Paths.get("src/main/resources/imgs/bee.jpeg"))), StandardCharsets.UTF_8);
        String imgDiario = "data:image/jpeg;charset=utf-8;base64," + new String(Base64.getEncoder().encode(Files.readAllBytes(Paths.get("src/main/resources/imgs/diario.jpg"))), StandardCharsets.UTF_8);

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

        Produto p1 = new Produto(u1, cat4, "Senhor dos aneis", "", imgSenhor);
        Produto p2 = new Produto(u2, cat5, "Mac Air m1", "", imgMac);
        Produto p3 = new Produto(u2, cat2, "Galaxy s22", "", imgGalaxy);
        Produto p4 = new Produto(u1, cat5, "Nintendo 3ds", "", imgNintendo);
        Produto p5 = new Produto(u1, cat2, "AirMax", "Trazendo impacto no visual clássico que seus filhos irão adorar, o tênis Nike Air Max 90 965 esbanja inovação sem comprometer sua originalidade! O design deste Air faz com que ele seja divertido, adicionando elegância e um visual dos anos 90 com detalhes minimalistas que renovam ainda mais o ícone do Air.", imgAirmax);
        Produto p6 = new Produto(u2, cat2, "Moletom", "", imgMoletom);
        Produto p8 = new Produto(u2, cat4, "Diário de um Banana 2: Rodrick é o Cara", "", imgDiario);
        Produto p9 = new Produto(u1, cat1, "Bee Movie", "", imgBee);
        Produto p10 = new Produto(u2, cat3, "Pote de Jardinagem", "Um vaso para jardim em cerâmica é uma peça encantadora que combina funcionalidade e beleza estética para realçar o ambiente externo. Seu design pode variar, desde formas clássicas e elegantes, estilos mais contemporâneos e artísticos. A cerâmica permite uma ampla gama de texturas e padrões, permitindo que o vaso se destaque como uma peça decorativa por si só ou como um complemento perfeito para as plantas que abrigam.", imgPote);
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p8, p9, p10));

        Troca tr1 = new Troca(u1, p1, false, null, null);
        Troca tr2 = new Troca(u2, p2, false, null, null);
        Troca tr3 = new Troca(u2, p3, false, null, null);
        Troca tr4 = new Troca(u1, p5, false, null, null);
        Troca tr5 = new Troca(u2, p6, false, null, null);
        trocaRepository.saveAll(Arrays.asList(tr1, tr2, tr3, tr4, tr5));

        Proposta prop1 = new Proposta(u1, tr5, p5, null, null, null);
        propostaRepository.save(prop1);

    }
}
