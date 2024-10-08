package com.DentalWareTeam.Oralytics.dto;

import com.DentalWareTeam.Oralytics.model.RelatoProblemaDentario;
import com.DentalWareTeam.Oralytics.model.Usuario;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

public class DadosMonitoramentoDTO {

    private Integer id;

    @NotNull
    private Usuario usuario;
    private Set<RelatoProblemaDentario> relatosProblemasDentarios;

    @NotNull
    private LocalDate dataRegistro;

    public DadosMonitoramentoDTO() {

    }

    public DadosMonitoramentoDTO(Integer id, Usuario usuario, Set<RelatoProblemaDentario> relatosProblemasDentarios, LocalDate dataRegistro) {
        this.id = id;
        this.usuario = usuario;
        this.relatosProblemasDentarios = relatosProblemasDentarios;
        this.dataRegistro = dataRegistro;
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

    public Set<RelatoProblemaDentario> getRelatosProblemasDentarios() {
        return relatosProblemasDentarios;
    }

    public void setRelatosProblemasDentarios(Set<RelatoProblemaDentario> relatosProblemasDentarios) {
        this.relatosProblemasDentarios = relatosProblemasDentarios;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
}
