package com.DentalWareTeam.Oralytics.mapper;

import com.DentalWareTeam.Oralytics.dto.HistoricoDentalDTO;
import com.DentalWareTeam.Oralytics.model.HistoricoDental;

public class HistoricoDentalMapper {

    public static HistoricoDentalDTO toDTO(HistoricoDental historicoDental){
        return new HistoricoDentalDTO(historicoDental.getId(),
                ProcedimentoDentarioMapper.toDTO(historicoDental.getProcedimentosDentarios()),
                UsuarioMapper.toDTO(historicoDental.getUsuario()),
                historicoDental.getDataConsulta(),
                historicoDental.getCondicaoDente()).add(historicoDental.getLinks());
    }
}
