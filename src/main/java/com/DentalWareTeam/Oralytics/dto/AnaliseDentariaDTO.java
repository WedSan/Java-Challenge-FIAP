package com.DentalWareTeam.Oralytics.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Set;

public class AnaliseDentariaDTO {

    private Integer id;

    private UsuarioDTO usuario;

    private LocalDateTime dataAnalise;

    @NotNull
    private double probalidadeProblema;

    private Set<DadosMonitoramentoDTO> dadosMonitoramento;

    public AnaliseDentariaDTO() {

    }

    public AnaliseDentariaDTO(Integer id, UsuarioDTO usuario, LocalDateTime dataAnalise, double probalidadeProblema, Set<DadosMonitoramentoDTO> dadosMonitoramento) {
        this.id = id;
        this.usuario = usuario;
        this.dataAnalise = dataAnalise;
        this.probalidadeProblema = probalidadeProblema;
        this.dadosMonitoramento = dadosMonitoramento;
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

    public void setProbalidadeProblema(double probalidadeProblema) {
        this.probalidadeProblema = probalidadeProblema;
    }

    public LocalDateTime getDataAnalise() {
        return dataAnalise;
    }

    public void setDataAnalise(LocalDateTime dataAnalise) {
        this.dataAnalise = dataAnalise;
    }

    public Double getProbalidadeProblema() {
        return probalidadeProblema;
    }

    public void setProbalidadeProblema(Double probalidadeProblema) {
        this.probalidadeProblema = probalidadeProblema;
    }

    public Set<DadosMonitoramentoDTO> getDadosMonitoramento() {
        return dadosMonitoramento;
    }

    public void setDadosMonitoramento(Set<DadosMonitoramentoDTO> dadosMonitoramento) {
        this.dadosMonitoramento = dadosMonitoramento;
    }
}
