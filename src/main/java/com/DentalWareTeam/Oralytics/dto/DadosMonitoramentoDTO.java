package com.DentalWareTeam.Oralytics.dto;

import com.DentalWareTeam.Oralytics.model.AnaliseDentaria;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;
import java.util.Set;

public class DadosMonitoramentoDTO extends RepresentationModel<DadosMonitoramentoDTO> {

    private Integer id;

    private UsuarioDTO usuario;
    
    private Set<RelatoProblemaDentarioDTO> relatosProblemasDentarios;

    private LocalDateTime dataRegistro;

    public DadosMonitoramentoDTO() {

    }

    public DadosMonitoramentoDTO(Integer id, UsuarioDTO usuario, Set<RelatoProblemaDentarioDTO> relatosProblemasDentarios, LocalDateTime dataRegistro) {
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

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public Set<RelatoProblemaDentarioDTO> getRelatosProblemasDentarios() {
        return relatosProblemasDentarios;
    }

    public void setRelatosProblemasDentarios(Set<RelatoProblemaDentarioDTO> relatosProblemasDentarios) {
        this.relatosProblemasDentarios = relatosProblemasDentarios;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
}
