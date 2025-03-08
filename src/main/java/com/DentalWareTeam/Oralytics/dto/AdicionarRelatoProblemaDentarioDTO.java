package com.DentalWareTeam.Oralytics.dto;

import com.DentalWareTeam.Oralytics.model.DadoMonitoramento;
import jakarta.validation.constraints.NotBlank;

public class AdicionarRelatoProblemaDentarioDTO {

    @NotBlank(message = "o campo de problema não pode ser nulo")
    private String problema;

    private DadoMonitoramento dadoMonitoramento;

    public AdicionarRelatoProblemaDentarioDTO() {
    }

    public AdicionarRelatoProblemaDentarioDTO(String problema) {
        this.problema = problema;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public DadoMonitoramento getDadoMonitoramento() {
        return dadoMonitoramento;
    }

    public void setDadoMonitoramento(DadoMonitoramento dadoMonitoramento) {
        this.dadoMonitoramento = dadoMonitoramento;
    }
}
