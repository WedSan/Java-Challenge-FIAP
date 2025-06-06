package com.DentalWareTeam.Oralytics.mapper;

import com.DentalWareTeam.Oralytics.dto.ListagemUsuarioDTO;
import com.DentalWareTeam.Oralytics.dto.UsuarioDTO;
import com.DentalWareTeam.Oralytics.model.Usuario;

import java.util.Collections;

public class UsuarioMapper {

        public static UsuarioDTO toDTO(Usuario usuario){
            return new UsuarioDTO(usuario.getId(),
                    usuario.getNome(),
                    usuario.getEmail(),
                    usuario.getSenha(),
                    usuario.getGenero(),
                    usuario.getRoles().toString());
        }

    public static ListagemUsuarioDTO toListagemUsuarioDTO(Usuario usuario){
        return new ListagemUsuarioDTO(usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(), usuario.getGenero());
    }

    public static Usuario toEntity (UsuarioDTO usuarioDTO) {
            return new Usuario(usuarioDTO.getId(),
                    usuarioDTO.getNome(),
                    usuarioDTO.getEmail(),
                    usuarioDTO.getSenha(),
                    usuarioDTO.getGenero(),
                    Collections.EMPTY_SET);
    }
}
