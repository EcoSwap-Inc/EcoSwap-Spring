package com.ecoswap.ecoswap.services;

import com.ecoswap.ecoswap.domain.Usuario;
import com.ecoswap.ecoswap.domain.Usuario;
import com.ecoswap.ecoswap.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuario() {
        return usuarioRepository.findAll();
    }

    public Usuario findUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario atualizarUsuario(Long id, Usuario usuario) {
        Optional<Usuario> usuarioExistenteOptional = Optional.ofNullable(usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com o ID: " + id)));

        Usuario usuarioExistente = usuarioExistenteOptional.get();

       usuarioExistente.setCep(usuario.getCep());
       usuarioExistente.setEmail(usuario.getEmail());
       usuarioExistente.setCidade(usuario.getCidade());
       usuarioExistente.setNome(usuario.getNome());
       usuarioExistente.setUF(usuario.getUF());
       usuarioExistente.setCidade(usuario.getCidade());
       usuarioExistente.setNumero_rua(usuario.getNumero_rua());
       usuarioExistente.setRua(usuario.getRua());
       usuarioExistente.setComplemento(usuario.getComplemento());

        return usuarioRepository.save(usuarioExistente);
    }

}
