package com.DentalWareTeam.Oralytics.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "TB_HISTORICO_DENTAL")
public class HistoricoDental {

    @Id
    private Integer id;
    private ProcedimentoDentario procedimentoDentario;
    private Usuario usuario;
    private LocalDate dataConsulta;
    private String condicaoDente;

    public HistoricoDental() {
    }

    public HistoricoDental(Integer id, ProcedimentoDentario procedimentoDentario, Usuario usuario, LocalDate dataConsulta, String condicaoDente) {
        this.id = id;
        this.procedimentoDentario = procedimentoDentario;
        this.usuario = usuario;
        this.dataConsulta = dataConsulta;
        this.condicaoDente = condicaoDente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProcedimentoDentario getProcedimentoDentario() {
        return procedimentoDentario;
    }

    public void setProcedimentoDentario(ProcedimentoDentario procedimentoDentario) {
        this.procedimentoDentario = procedimentoDentario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getCondicaoDente() {
        return condicaoDente;
    }

    public void setCondicaoDente(String condicaoDente) {
        this.condicaoDente = condicaoDente;
    }
}
