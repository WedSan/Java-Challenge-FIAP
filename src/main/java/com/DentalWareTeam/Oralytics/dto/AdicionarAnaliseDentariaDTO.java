package com.DentalWareTeam.Oralytics.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class AdicionarAnaliseDentariaDTO {

    @NotNull(message = "id do usuario não pode ser nulo")
    private int usuarioId;

    @NotNull(message = "o campo de probabilidade de problema não pode ser nulo")
    private double probalidadeProblema;

    @NotNull(message = "o campo de dados de monitoramento não pode ser nulo")
    private List<Integer> dadosMonitoramentoIds;

    public AdicionarAnaliseDentariaDTO() {
    }

    public AdicionarAnaliseDentariaDTO(int usuarioId, double probalidadeProblema, List<Integer> dadosMonitoramentoIds) {
        this.usuarioId = usuarioId;
        this.probalidadeProblema = probalidadeProblema;
        this.dadosMonitoramentoIds = dadosMonitoramentoIds;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public double getProbalidadeProblema() {
        return probalidadeProblema;
    }

    public void setProbalidadeProblema(double probalidadeProblema) {
        this.probalidadeProblema = probalidadeProblema;
    }

    public List<Integer> getDadosMonitoramentoIds() {
        return dadosMonitoramentoIds;
    }

    public void setDadosMonitoramentoIds(List<Integer> dadosMonitoramentoIds) {
        this.dadosMonitoramentoIds = dadosMonitoramentoIds;
    }
}
