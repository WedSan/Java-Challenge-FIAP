package com.DentalWareTeam.Oralytics.dto;

import com.DentalWareTeam.Oralytics.model.ProcedimentoDentario;

import java.time.LocalDate;
import java.util.Set;

public class HistoricoDentalDTO {

    private Integer id;
    private Integer idProcedimentoDentario;
    private Integer idUsuario;
    private LocalDate dataConsulta;
    private String condicaoDente;

    private Set<ProcedimentoDentarioDTO> procedimentosDentarios;

    public HistoricoDentalDTO(Integer id, Integer idProcedimentoDentario, Integer idUsuario, LocalDate dataConsulta, String condicaoDente, Set<ProcedimentoDentarioDTO> procedimentosDentarios) {
        this.id = id;
        this.idProcedimentoDentario = idProcedimentoDentario;
        this.idUsuario = idUsuario;
        this.dataConsulta = dataConsulta;
        this.condicaoDente = condicaoDente;
        this.procedimentosDentarios = procedimentosDentarios;
    }

    public HistoricoDentalDTO() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdProcedimentoDentario() {
        return idProcedimentoDentario;
    }

    public void setIdProcedimentoDentario(Integer idProcedimentoDentario) {
        this.idProcedimentoDentario = idProcedimentoDentario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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

    public Set<ProcedimentoDentarioDTO> getProcedimentosDentarios() {
        return procedimentosDentarios;
    }

    public void setProcedimentosDentarios(Set<ProcedimentoDentarioDTO> procedimentosDentarios) {
        this.procedimentosDentarios = procedimentosDentarios;
    }
}
