package com.DentalWareTeam.Oralytics.dto;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.HashSet;

public class AdicionarHistoricoDentalDTO {

    private Integer usuarioId;
    private String condicaoDente;
    private LocalDateTime dataConsulta;
    private Set<Integer> procedimentosDentarios;

    public AdicionarHistoricoDentalDTO() {
        this.procedimentosDentarios = new HashSet<>();
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getCondicaoDente() {
        return condicaoDente;
    }

    public void setCondicaoDente(String condicaoDente) {
        this.condicaoDente = condicaoDente;
    }

    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Set<Integer> getProcedimentosDentarios() {
        return procedimentosDentarios;
    }

    public void setProcedimentosDentarios(Set<Integer> procedimentosDentarios) {
        this.procedimentosDentarios = procedimentosDentarios;
    }
}
