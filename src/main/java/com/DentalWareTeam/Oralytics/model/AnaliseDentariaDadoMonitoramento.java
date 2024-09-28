package com.DentalWareTeam.Oralytics.model;

public class AnaliseDentariaDadoMonitoramento {

    private int id_analise_dentaria;
    private int id_dado_monitoramento;

    public AnaliseDentariaDadoMonitoramento() {
    }

    public AnaliseDentariaDadoMonitoramento(int id_analise_dentaria, int id_dado_monitoramento) {
        this.id_analise_dentaria = id_analise_dentaria;
        this.id_dado_monitoramento = id_dado_monitoramento;
    }

    public int getId_analise_dentaria() {
        return id_analise_dentaria;
    }

    public void setId_analise_dentaria(int id_analise_dentaria) {
        this.id_analise_dentaria = id_analise_dentaria;
    }

    public int getId_dado_monitoramento() {
        return id_dado_monitoramento;
    }

    public void setId_dado_monitoramento(int id_dado_monitoramento) {
        this.id_dado_monitoramento = id_dado_monitoramento;
    }
}
