package com.DentalWareTeam.Oralytics.mapper;

import com.DentalWareTeam.Oralytics.dto.DadosMonitoramentoDTO;
import com.DentalWareTeam.Oralytics.model.DadoMonitoramento;

import java.util.Set;
import java.util.stream.Collectors;

public class DadosMonitoramentoMapper {

    public static DadosMonitoramentoDTO toDTO(DadoMonitoramento dadoMonitoramento){
        return new DadosMonitoramentoDTO(dadoMonitoramento.getId(),
                UsuarioMapper.toDTO(dadoMonitoramento.getUsuario()),
                RelatoProblemaDentarioMapper.toDTO(dadoMonitoramento.getRelatosProblemasDentarios()),
                dadoMonitoramento.getDataRegistro());
    }

    public static Set<DadosMonitoramentoDTO> toDTO(Set<DadoMonitoramento> dadoMonitoramentos){
        return dadoMonitoramentos.stream()
                .map(e -> toDTO(e))
                .collect(Collectors.toSet());
    }
}
