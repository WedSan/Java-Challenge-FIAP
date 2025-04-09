package com.DentalWareTeam.Oralytics.mapper;

import com.DentalWareTeam.Oralytics.dto.ListagemUsuarioDTO;
import com.DentalWareTeam.Oralytics.dto.UsuarioDTO;
import com.DentalWareTeam.Oralytics.model.user.Usuario;

public class UsuarioMapper {

        public static UsuarioDTO toDTO(Usuario usuario){
            return new UsuarioDTO(usuario.getId(),
                    usuario.getNome(),
                    usuario.getEmail(),
                    usuario.getSenha(),
                    usuario.getGenero());
        }

    public static ListagemUsuarioDTO toListagemUsuarioDTO(Usuario usuario){
        return new ListagemUsuarioDTO(usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(), usuario.getGenero());
    }
}
