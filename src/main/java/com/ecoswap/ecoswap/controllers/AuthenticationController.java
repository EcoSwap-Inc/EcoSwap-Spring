package com.ecoswap.ecoswap.controllers;

import com.ecoswap.ecoswap.domain.users.AuthenticationDTO;
import com.ecoswap.ecoswap.domain.users.LoginResponseDTO;
import com.ecoswap.ecoswap.domain.users.RegistrationDTO;
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
@RequestMapping("/auth")
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

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        System.out.println("TOKEN: " + token);

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/registrar")
    public ResponseEntity registrar(@RequestBody @Valid RegistrationDTO data) {
        //        if (usuarioRepository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        System.out.println(data);
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());

        Usuario newUser = new Usuario(data.email(), encryptedPassword, data.nome(), data.cidade(),
                data.uf(), data.cep(), data.rua(), 1, null);

        this.usuarioRepository.save(newUser);

        return ResponseEntity.ok().build();
    }

}
