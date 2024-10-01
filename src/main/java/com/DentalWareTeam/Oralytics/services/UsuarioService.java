package com.DentalWareTeam.Oralytics.services;

import com.DentalWareTeam.Oralytics.dto.UsuarioDTO;
import com.DentalWareTeam.Oralytics.exceptions.UsuarioNotFoundException;
import com.DentalWareTeam.Oralytics.model.Usuario;
import com.DentalWareTeam.Oralytics.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public Usuario salvarUsuario (UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setName(usuarioDTO.getName());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setGenero(usuarioDTO.getGenero());

        return usuarioRepository.save(usuario);
    }

    @Transactional
    public void deletarUsuario (Integer id) throws UsuarioNotFoundException {
        if (!usuarioRepository.existsById(id)){
           throw new UsuarioNotFoundException("Usuário não encontrado com o ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }

    public Usuario lerUsuario (Integer id) throws UsuarioNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return usuario.get();
        } else {
            throw new UsuarioNotFoundException("Usuário não encontrado com ID: " + id);
        }
    }

    @Transactional
    public void atualizarEmail (Integer id, String email) throws UsuarioNotFoundException {
        Usuario usuario = lerUsuario(id);
        usuario.setEmail(email);
    }

    @Transactional
    public void atualizarSenha (Integer id, String senha) throws UsuarioNotFoundException {
        Usuario usuario = lerUsuario(id);
        usuario.setSenha(senha);
    }

}
