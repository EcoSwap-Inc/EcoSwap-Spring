package com.ecoswap.ecoswap.services;

import com.ecoswap.ecoswap.domain.InputClasses.UsuarioInput;
import com.ecoswap.ecoswap.domain.users.Usuario;
import com.ecoswap.ecoswap.exception.NoSuchElementFoundException;
import com.ecoswap.ecoswap.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
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

    public ResponseEntity<String> atualizarUsuario(Long id, UsuarioInput usuario) {
        if (usuario.getCidade() == null && usuario.getNome() == null && usuario.getEmail() == null && usuario.getComplemento() == null && usuario.getCep() == 0 && usuario.getNumero_rua() == 0 && usuario.getRua() == null && usuario.getSenha() == null && usuario.getUF() == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"status\": \"400\", \"data\": \"" + LocalDateTime.now() + "\", \"mensagem\": \"Nenhum campo válido de 'Usuário' foi informado\"}");

        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException("Usuário não encontrado com o ID: " + id));

        if (usuario.getCep() != 0)
            usuarioExistente.setCep(usuario.getCep());
        if (usuario.getEmail() != null)
            usuarioExistente.setEmail(usuario.getEmail());
        if (usuario.getCidade() != null)
            usuarioExistente.setCidade(usuario.getCidade());
        if (usuario.getNome() != null)
            usuarioExistente.setNome(usuario.getNome());
        if (usuario.getUF() != null)
            usuarioExistente.setUF(usuario.getUF());
        if (usuario.getSenha() != null)
            usuarioExistente.setUF(usuario.getSenha());
        if (usuario.getNumero_rua() != 0)
            usuarioExistente.setNumero_rua(usuario.getNumero_rua());
        if (usuario.getRua() != null)
            usuarioExistente.setRua(usuario.getRua());
        if (usuario.getComplemento() != null)
            usuarioExistente.setComplemento(usuario.getComplemento());

        usuarioRepository.save(usuarioExistente);
        return ResponseEntity.status(HttpStatus.OK).body("{\"status\": \"200\", \"data\": \"" + LocalDateTime.now() + "\", \"mensagem\": \"Usuário com ID " + id + " atualizado com sucesso\"}");
    }

}
