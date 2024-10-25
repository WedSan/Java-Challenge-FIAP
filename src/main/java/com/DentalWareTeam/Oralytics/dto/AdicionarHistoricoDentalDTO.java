package com.DentalWareTeam.Oralytics.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Set;

public class AdicionarHistoricoDentalDTO {

    private Set<AdicionarProcedimentosDentarioDTO> procedimentosDentarios;

    @NotNull(message = "id do usuario não pode ser nulo")
    private int usuarioId;

    @NotBlank(message = "o campo de condição do dente não pode ser nulo")
    private String condicaoDente;

    @NotNull(message = "o campo de data da consulta não pode ser nulo")
    private LocalDateTime dataConsulta;

    public AdicionarHistoricoDentalDTO(Set<AdicionarProcedimentosDentarioDTO> procedimentosDentarios, int usuarioId, String condicaoDente, LocalDateTime dataConsulta) {
        this.procedimentosDentarios = procedimentosDentarios;
        this.usuarioId = usuarioId;
        this.condicaoDente = condicaoDente;
        this.dataConsulta = dataConsulta;
    }

    public AdicionarHistoricoDentalDTO(LocalDateTime dataConsulta) {

        this.dataConsulta = dataConsulta;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getCondicaoDente() {
        return condicaoDente;
    }

    public void setCondicaoDente(String condicaoDente) {
        this.condicaoDente = condicaoDente;
    }

    public Set<AdicionarProcedimentosDentarioDTO> getProcedimentosDentarios() {
        return procedimentosDentarios;
    }

    public void setProcedimentosDentarios(Set<AdicionarProcedimentosDentarioDTO> procedimentosDentarios) {
        this.procedimentosDentarios = procedimentosDentarios;
    }

    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }
}
