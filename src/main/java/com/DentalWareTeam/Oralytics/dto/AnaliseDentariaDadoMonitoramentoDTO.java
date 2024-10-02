package com.DentalWareTeam.Oralytics.dto;

public class AnaliseDentariaDadoMonitoramentoDTO {

    private int idAnaliseDentaria;
    private int idDadoMonitoramento;

    public AnaliseDentariaDadoMonitoramentoDTO() {

    }

    public AnaliseDentariaDadoMonitoramentoDTO(int idAnaliseDentaria, int idDadoMonitoramento) {
        this.idAnaliseDentaria = idAnaliseDentaria;
        this.idDadoMonitoramento = idDadoMonitoramento;
    }

    public int getIdAnaliseDentaria() {
        return idAnaliseDentaria;
    }

    public void setIdAnaliseDentaria(int idAnaliseDentaria) {
        this.idAnaliseDentaria = idAnaliseDentaria;
    }

    public int getIdDadoMonitoramento() {
        return idDadoMonitoramento;
    }

    public void setIdDadoMonitoramento(int idDadoMonitoramento) {
        this.idDadoMonitoramento = idDadoMonitoramento;
    }
}
