package com.DentalWareTeam.Oralytics.dto;

import com.DentalWareTeam.Oralytics.model.DadoMonitoramento;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class RelatoProblemaDentarioDTO {

    private Integer id;

    @NotNull
    @Max(30)
    private String problema;
    private List<DadoMonitoramento> dadosMonitoramento;

    public RelatoProblemaDentarioDTO() {

    }

    public RelatoProblemaDentarioDTO(Integer id, String problema, List<DadoMonitoramento> dadosMonitoramento) {
        this.id = id;
        this.problema = problema;
        this.dadosMonitoramento = dadosMonitoramento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public List<DadoMonitoramento> getDadosMonitoramento() {
        return dadosMonitoramento;
    }

    public void setDadosMonitoramento(List<DadoMonitoramento> dadosMonitoramento) {
        this.dadosMonitoramento = dadosMonitoramento;
    }
}
