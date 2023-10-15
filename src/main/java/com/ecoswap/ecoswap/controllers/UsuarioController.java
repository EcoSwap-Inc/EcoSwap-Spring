package com.ecoswap.ecoswap.controllers;

import com.ecoswap.ecoswap.domain.Usuario;
import com.ecoswap.ecoswap.services.UsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/")
    public ResponseEntity<String> salvarUsuario(@Valid @RequestBody Usuario Usuario) {
        return usuarioService.salvarUsuario(Usuario);
    }

    @GetMapping("/")
    public List<Usuario> listarUsuario() {
        return usuarioService.listarUsuario();
    }

    @GetMapping("/{id}")
    public Usuario findUsuarioById(@PathVariable Long id) {
        return usuarioService.findUsuarioById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarUsuario(@PathVariable Long id) {
        return usuarioService.deletarUsuario(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarUsuario(@PathVariable Long id, @Valid @RequestBody Usuario usuario) {
        return usuarioService.atualizarUsuario(id, usuario);
    }

}
