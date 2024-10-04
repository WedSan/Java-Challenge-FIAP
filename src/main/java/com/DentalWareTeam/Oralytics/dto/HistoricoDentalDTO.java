package com.DentalWareTeam.Oralytics.dto;

import com.DentalWareTeam.Oralytics.model.ProcedimentoDentario;
import com.DentalWareTeam.Oralytics.model.Usuario;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

public class HistoricoDentalDTO {

    private Integer id;
    private Set<ProcedimentoDentario> procedimentosDentarios;

    @NotNull
    private Usuario usuario;

    @NotNull
    private LocalDate dataConsulta;

    @Max(30)
    private String condicaoDente;

    public HistoricoDentalDTO(Integer id, Set<ProcedimentoDentario> procedimentosDentarios, Usuario usuario, LocalDate dataConsulta, String condicaoDente) {
        this.id = id;
        this.procedimentosDentarios = procedimentosDentarios;
        this.usuario = usuario;
        this.dataConsulta = dataConsulta;
        this.condicaoDente = condicaoDente;
    }

    public HistoricoDentalDTO() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Set<ProcedimentoDentario> getProcedimentosDentarios() {
        return procedimentosDentarios;
    }

    public void setProcedimentosDentarios(Set<ProcedimentoDentario> procedimentosDentarios) {
        this.procedimentosDentarios = procedimentosDentarios;
    }
}
