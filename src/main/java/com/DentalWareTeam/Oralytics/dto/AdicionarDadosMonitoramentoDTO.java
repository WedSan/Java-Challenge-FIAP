package com.DentalWareTeam.Oralytics.dto;

import jakarta.validation.constraints.NotNull;

import java.util.Set;

public class AdicionarDadosMonitoramentoDTO {

    @NotNull(message = "O id do usuário não pode ser nulo")
    private int usuarioId;

    private Set<AdicionarRelatoProblemaDentarioDTO> relatosProblemasDentarios;

    public AdicionarDadosMonitoramentoDTO() {
    }

    public AdicionarDadosMonitoramentoDTO(int usuarioId, Set<AdicionarRelatoProblemaDentarioDTO> relatosProblemasDentarios) {
        this.usuarioId = usuarioId;
        this.relatosProblemasDentarios = relatosProblemasDentarios;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Set<AdicionarRelatoProblemaDentarioDTO> getRelatosProblemasDentarios() {
        return relatosProblemasDentarios;
    }

    public void setRelatosProblemasDentarios(Set<AdicionarRelatoProblemaDentarioDTO> relatosProblemasDentarios) {
        this.relatosProblemasDentarios = relatosProblemasDentarios;
    }

}
