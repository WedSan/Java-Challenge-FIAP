package com.DentalWareTeam.Oralytics.model;

import java.time.LocalDate;

public class HistoricoDental {

    private int id;
    private int id_procedimento_dentario;
    private int id_usuario;
    private LocalDate data_consulta;
    private String condicao_dente;

    public HistoricoDental() {
    }

    public HistoricoDental(int id, int id_procedimento_dentario, int id_usuario, LocalDate data_consulta, String condicao_dente) {
        this.id = id;
        this.id_procedimento_dentario = id_procedimento_dentario;
        this.id_usuario = id_usuario;
        this.data_consulta = data_consulta;
        this.condicao_dente = condicao_dente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_procedimento_dentario() {
        return id_procedimento_dentario;
    }

    public void setId_procedimento_dentario(int id_procedimento_dentario) {
        this.id_procedimento_dentario = id_procedimento_dentario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public LocalDate getData_consulta() {
        return data_consulta;
    }

    public void setData_consulta(LocalDate data_consulta) {
        this.data_consulta = data_consulta;
    }

    public String getCondicao_dente() {
        return condicao_dente;
    }

    public void setCondicao_dente(String condicao_dente) {
        this.condicao_dente = condicao_dente;
    }
}
