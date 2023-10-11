package com.ecoswap.ecoswap.controllers;


import com.ecoswap.ecoswap.domain.Usuario;
import com.ecoswap.ecoswap.domain.Usuario;
import com.ecoswap.ecoswap.repository.UsuarioRepository;
import com.ecoswap.ecoswap.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario salvarUsuario(@RequestBody Usuario Usuario) {
        return usuarioService.salvarUsuario(Usuario);
    }

    @GetMapping
    public List<Usuario> listarUsuario() {
        return usuarioService.listarUsuario();
    }

    @GetMapping("/{id}")
    public Usuario findUsuarioById(@PathVariable Long id) {
        return usuarioService.findUsuarioById(id);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.atualizarUsuario(id, usuario));
    }

}
