package com.ecoswap.ecoswap.services;

import com.ecoswap.ecoswap.domain.Usuario;
import com.ecoswap.ecoswap.exception.NoSuchElementFoundException;
import com.ecoswap.ecoswap.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity<String> salvarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body("{\"status\": \"201\", \"data\": \"" + LocalDateTime.now() + "\", \"mensagem\": \"Usuário com ID " + usuario.getId_usuario() + " inserido com sucesso\"}");
    }

    public List<Usuario> listarUsuario() {
        return usuarioRepository.findAll();
    }

    public Usuario findUsuarioById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException("Usuário não encontrado com o ID: " + id));
    }

    public ResponseEntity<String> validarLogin(String email, String senha) {
        return ResponseEntity.status(HttpStatus.OK).body("{\"status\": \"200\", \"data\": \"" + LocalDateTime.now() + "\", \"resultado\": " + usuarioRepository.validarLogin(email, senha) + "}");
    }

    public ResponseEntity<String> deletarUsuario(Long id) {
        if (usuarioRepository.existsById(id))
            usuarioRepository.deleteById(id);
        else
            throw new NoSuchElementFoundException("Usuário não encontrado com o ID: " + id);
        return ResponseEntity.status(HttpStatus.OK).body("{\"status\": \"200\", \"data\": \"" + LocalDateTime.now() + "\", \"mensagem\": \"Usuário com ID " + id + " deletado com sucesso\"}");
    }

    public ResponseEntity<String> atualizarUsuario(Long id, Usuario usuario) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException("Usuário não encontrado com o ID: " + id));

        usuarioExistente.setCep(usuario.getCep());
        usuarioExistente.setEmail(usuario.getEmail());
        usuarioExistente.setCidade(usuario.getCidade());
        usuarioExistente.setNome(usuario.getNome());
        usuarioExistente.setUF(usuario.getUF());
        usuarioExistente.setCidade(usuario.getCidade());
        usuarioExistente.setNumero_rua(usuario.getNumero_rua());
        usuarioExistente.setRua(usuario.getRua());
        usuarioExistente.setComplemento(usuario.getComplemento());

        usuarioRepository.save(usuarioExistente);
        return ResponseEntity.status(HttpStatus.OK).body("{\"status\": \"200\", \"data\": \"" + LocalDateTime.now() + "\", \"mensagem\": \"Usuário com ID " + id + " atualizado com sucesso\"}");
    }

}
