package com.DentalWareTeam.Oralytics.mapper;

import com.DentalWareTeam.Oralytics.dto.UsuarioDTO;
import com.DentalWareTeam.Oralytics.model.Usuario;

public class UsuarioMapper {

        public static UsuarioDTO toDTO(Usuario usuario){
            return new UsuarioDTO(usuario.getId(),
                    usuario.getName(),
                    usuario.getEmail(),
                    usuario.getSenha(),
                    usuario.getGenero()).add(usuario.getLinks());
        }
}
