package com.DentalWareTeam.Oralytics.mapper;

import com.DentalWareTeam.Oralytics.dto.AnaliseDentariaDTO;
import com.DentalWareTeam.Oralytics.model.AnaliseDentaria;

public class AnaliseDentariaMapper {

    public static AnaliseDentariaDTO toDTO(AnaliseDentaria analiseDentaria){
        return new AnaliseDentariaDTO(
                analiseDentaria.getId(),
                UsuarioMapper.toDTO(analiseDentaria.getUsuario()),
                analiseDentaria.getDataAnalise(),
                analiseDentaria.getProbabilidadeProblema(),
                DadosMonitoramentoMapper.toDTO(analiseDentaria.getDadosMonitoramento())
        );
    }
}
