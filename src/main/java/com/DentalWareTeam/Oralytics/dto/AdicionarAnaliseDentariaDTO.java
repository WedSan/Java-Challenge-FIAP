package com.DentalWareTeam.Oralytics.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class AdicionarAnaliseDentariaDTO {
    
    private Integer usuarioId;

    private Double probabilidadeProblema;

    private List<Integer> dadosMonitoramentoIds;

    public AdicionarAnaliseDentariaDTO() {
    }

    public AdicionarAnaliseDentariaDTO(Integer usuarioId, Double probabilidadeProblema, List<Integer> dadosMonitoramentoIds) {
        this.usuarioId = usuarioId;
        this.probabilidadeProblema = probabilidadeProblema;
        this.dadosMonitoramentoIds = dadosMonitoramentoIds;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Double getProbabilidadeProblema() {
        return probabilidadeProblema;
    }

    public void setProbabilidadeProblema(Double probabilidadeProblema) {
        this.probabilidadeProblema = probabilidadeProblema;
    }

    public List<Integer> getDadosMonitoramentoIds() {
        return dadosMonitoramentoIds;
    }

    public void setDadosMonitoramentoIds(List<Integer> dadosMonitoramentoIds) {
        this.dadosMonitoramentoIds = dadosMonitoramentoIds;
    }
}
