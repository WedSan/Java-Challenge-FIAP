package com.DentalWareTeam.Oralytics.dto;

import com.DentalWareTeam.Oralytics.model.ProcedimentoDentario;
import com.DentalWareTeam.Oralytics.model.Usuario;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;
import java.util.Set;

public class HistoricoDentalDTO extends RepresentationModel<HistoricoDentalDTO> {

    private Integer id;
    private Set<ProcedimentoDentarioDTO> procedimentosDentarios;

    @NotNull
    private ListagemUsuarioDTO usuario;

    @NotNull
    private LocalDateTime dataConsulta;

    @Max(30)
    private String condicaoDente;

    public HistoricoDentalDTO(Integer id, Set<ProcedimentoDentarioDTO> procedimentosDentarios, ListagemUsuarioDTO  usuario , LocalDateTime dataConsulta, String condicaoDente) {
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

    public Set<ProcedimentoDentarioDTO> getProcedimentosDentarios() {
        return procedimentosDentarios;
    }

    public void setProcedimentosDentarios(Set<ProcedimentoDentarioDTO> procedimentosDentarios) {
        this.procedimentosDentarios = procedimentosDentarios;
    }

    public @NotNull ListagemUsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(@NotNull ListagemUsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public @NotNull LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(@NotNull LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public @Max(30) String getCondicaoDente() {
        return condicaoDente;
    }

    public void setCondicaoDente(@Max(30) String condicaoDente) {
        this.condicaoDente = condicaoDente;
    }
}
