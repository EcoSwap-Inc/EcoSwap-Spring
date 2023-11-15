package com.ecoswap.ecoswap.controllers;

import com.ecoswap.ecoswap.domain.InputClasses.UsuarioInput;
import com.ecoswap.ecoswap.domain.users.Usuario;
import com.ecoswap.ecoswap.services.UsuarioService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/")
    public ResponseEntity<String> salvarUsuario(@Valid @RequestBody UsuarioInput usuario) {
        return usuarioService.salvarUsuario(usuario);
    }

    @GetMapping("/")
    public List<Usuario> listarUsuario() {
        return usuarioService.listarUsuario();
    }

    @GetMapping("/{id}")
    public Usuario findUsuarioById(@PathVariable @Positive Long id) {
        return usuarioService.findUsuarioById(id);
    }

    @GetMapping("/validarLogin/")
    public ResponseEntity<String> validarLogin(@RequestParam(name = "email") @Email String email, @RequestParam(name = "senha") String senha) {
        return usuarioService.validarLogin(email, senha);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarUsuario(@PathVariable @Positive Long id) {
        return usuarioService.deletarUsuario(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarUsuario(@PathVariable @Positive Long id, @Valid @RequestBody UsuarioInput usuario) {
        return usuarioService.atualizarUsuario(id, usuario);
    }


}
