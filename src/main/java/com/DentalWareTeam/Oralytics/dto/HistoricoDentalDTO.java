package com.DentalWareTeam.Oralytics.dto;

import com.DentalWareTeam.Oralytics.model.ProcedimentoDentario;
import com.DentalWareTeam.Oralytics.model.Usuario;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Set;

public class HistoricoDentalDTO {

    private Integer id;
    private Set<ProcedimentoDentarioDTO> procedimentosDentarios;

    @NotNull
    private UsuarioDTO usuario;

    @NotNull
    private LocalDateTime dataConsulta;

    @Max(30)
    private String condicaoDente;

    public HistoricoDentalDTO(Integer id, Set<ProcedimentoDentarioDTO> procedimentosDentarios, UsuarioDTO  usuario , LocalDateTime dataConsulta, String condicaoDente) {
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

    public UsuarioDTO  getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDateTime dataConsulta) {
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
