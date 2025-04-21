package com.DentalWareTeam.Oralytics.services;

import com.DentalWareTeam.Oralytics.dto.ListagemUsuarioDTO;
import com.DentalWareTeam.Oralytics.dto.UsuarioDTO;
import com.DentalWareTeam.Oralytics.exceptions.UsuarioNotFoundException;
import com.DentalWareTeam.Oralytics.mapper.UsuarioMapper;
import com.DentalWareTeam.Oralytics.model.Usuario;
import com.DentalWareTeam.Oralytics.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements UserDetailsService {


    private final UsuarioRepository usuarioRepository;


    private final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;


    public UsuarioService(UsuarioRepository usuarioRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    private ListagemUsuarioDTO convertToListagemUsarioDTO (Usuario usuario) {
        return modelMapper.map(usuario, ListagemUsuarioDTO.class);
    }


    @Transactional
    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = UsuarioMapper.toEntity(usuarioDTO);
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return UsuarioMapper.toDTO(usuarioSalvo);
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

    public List<ListagemUsuarioDTO> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(this::convertToListagemUsarioDTO)
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
        usuario.setSenha(passwordEncoder.encode(senha));
        usuarioRepository.save(usuario);
        return usuario;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return usuarioRepository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }


}
