package com.ecoswap.ecoswap.controllers;

import com.ecoswap.ecoswap.domain.InputClasses.UsuarioInput;
import com.ecoswap.ecoswap.domain.users.AuthenticationDTO;
import com.ecoswap.ecoswap.domain.users.LoginResponseDTO;
import com.ecoswap.ecoswap.domain.users.Usuario;
import com.ecoswap.ecoswap.infra.security.TokenService;
import com.ecoswap.ecoswap.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        var userNamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var auth = authenticationManager.authenticate(userNamePassword);

        Usuario user = (Usuario) auth.getPrincipal();
        String token = tokenService.generateToken(user);
        System.out.println(data);

        return ResponseEntity.ok(new LoginResponseDTO(token, user.getId_usuario()));
    }

    @PostMapping("/registrar")
    public ResponseEntity registrar(@RequestBody UsuarioInput usuario) {
        Usuario novoUsuario = new Usuario();

        System.out.println(usuario);
        if (usuario.getCep() != 0)
            novoUsuario.setCep(usuario.getCep());
        if (usuario.getEmail() != null)
            novoUsuario.setEmail(usuario.getEmail());
        if (usuario.getSenha() != null) {
            String encryptedPassword = new BCryptPasswordEncoder().encode(usuario.getSenha());
            novoUsuario.setSenha(encryptedPassword);
        }
        if (usuario.getCidade() != null)
            novoUsuario.setCidade(usuario.getCidade());
        if (usuario.getNome() != null)
            novoUsuario.setNome(usuario.getNome());
        if (usuario.getUF() != null)
            novoUsuario.setUF(usuario.getUF());
        if (usuario.getNumero_rua() != 0)
            novoUsuario.setNumero_rua(usuario.getNumero_rua());
        if (usuario.getRua() != null)
            novoUsuario.setRua(usuario.getRua());
        if (usuario.getComplemento() != null)
            novoUsuario.setComplemento(usuario.getComplemento());
        if (usuario.getImagem() != null)
            novoUsuario.setImagem(usuario.getImagem());
        if (usuario.getDataNasc() != null)
            novoUsuario.setDataNasc(usuario.getDataNasc());
        if (usuario.getTelefone() != null)
            novoUsuario.setTelefone(usuario.getTelefone());

        System.out.println(novoUsuario);

        this.usuarioRepository.save(novoUsuario);

        return ResponseEntity.ok().build();
    }

}
