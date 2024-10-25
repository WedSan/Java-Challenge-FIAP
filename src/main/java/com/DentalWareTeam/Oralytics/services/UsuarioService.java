package com.DentalWareTeam.Oralytics.services;

import com.DentalWareTeam.Oralytics.dto.UsuarioDTO;
import com.DentalWareTeam.Oralytics.exceptions.UsuarioNotFoundException;
import com.DentalWareTeam.Oralytics.model.Usuario;
import com.DentalWareTeam.Oralytics.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private final UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper modelMapper;


    public UsuarioService(UsuarioRepository usuarioRepository, ModelMapper modelMapper) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
    }

    private UsuarioDTO convertToDTO(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    private Usuario convertToEntity(UsuarioDTO usuarioDTO) {
        return modelMapper.map(usuarioDTO, Usuario.class);
    }

    @Transactional
    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = convertToEntity(usuarioDTO);
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return convertToDTO(usuarioSalvo);
    }

    @Transactional
    public void deletarUsuario (Integer id) throws EntityNotFoundException {
        if (!usuarioRepository.existsById(id)){
           throw new UsuarioNotFoundException("Usuário não encontrado com o ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }

    public Usuario lerUsuario (Integer id) throws EntityNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return usuario.get();
        } else {
            throw new EntityNotFoundException("Usuário não encontrado com ID: " + id);
        }
    }

    public List<UsuarioDTO> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public Usuario atualizarEmail (Integer id, String email) throws UsuarioNotFoundException {
        Usuario usuario = lerUsuario(id);
        usuario.setEmail(email);
        usuarioRepository.save(usuario);
        return usuario;
    }

    @Transactional
    public Usuario atualizarSenha (Integer id, String senha) throws UsuarioNotFoundException {
        Usuario usuario = lerUsuario(id);
        usuario.setSenha(senha);
        usuarioRepository.save(usuario);
        return usuario;
    }

}
