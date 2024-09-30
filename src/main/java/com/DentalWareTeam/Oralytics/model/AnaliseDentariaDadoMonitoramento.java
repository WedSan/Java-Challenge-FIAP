package com.DentalWareTeam.Oralytics.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_ANALISE_DENTARIA_DADO_MONITORAMENTO")
public class AnaliseDentariaDadoMonitoramento {

    @JoinColumn(name = "id_analise_dentaria")
    @ManyToOne
    private AnaliseDentaria analiseDentaria;

    @JoinColumn(name = "id_dado_monitoramento")
    @ManyToOne
    private DadoMonitoramento dadoMonitoramento;

    public AnaliseDentariaDadoMonitoramento() {
    }

    public AnaliseDentariaDadoMonitoramento(AnaliseDentaria analiseDentaria, DadoMonitoramento dadoMonitoramento) {
        this.analiseDentaria = analiseDentaria;
        this.dadoMonitoramento = dadoMonitoramento;
    }

    public AnaliseDentaria getAnaliseDentaria() {
        return analiseDentaria;
    }

    public void setAnaliseDentaria(AnaliseDentaria analiseDentaria) {
        this.analiseDentaria = analiseDentaria;
    }

    public DadoMonitoramento getDadoMonitoramento() {
        return dadoMonitoramento;
    }

    public void setDadoMonitoramento(DadoMonitoramento dadoMonitoramento) {
        this.dadoMonitoramento = dadoMonitoramento;
    }
}
