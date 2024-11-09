package com.DentalWareTeam.Oralytics.dto;

import jakarta.validation.constraints.NotNull;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;
import java.util.Set;

public class AnaliseDentariaDTO extends RepresentationModel<AnaliseDentariaDTO> {

    private Integer id;

    private ListagemUsuarioDTO usuario;

    private LocalDateTime dataAnalise;

    @NotNull
    private double probalidadeProblema;

    private Set<DadosMonitoramentoDTO> dadosMonitoramento;

    public AnaliseDentariaDTO() {

    }

    public AnaliseDentariaDTO(Integer id, ListagemUsuarioDTO usuario, LocalDateTime dataAnalise, double probalidadeProblema, Set<DadosMonitoramentoDTO> dadosMonitoramento) {
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

    public ListagemUsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(ListagemUsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getDataAnalise() {
        return dataAnalise;
    }

    public void setDataAnalise(LocalDateTime dataAnalise) {
        this.dataAnalise = dataAnalise;
    }

    @NotNull
    public double getProbalidadeProblema() {
        return probalidadeProblema;
    }

    public void setProbalidadeProblema(@NotNull double probalidadeProblema) {
        this.probalidadeProblema = probalidadeProblema;
    }

    public Set<DadosMonitoramentoDTO> getDadosMonitoramento() {
        return dadosMonitoramento;
    }

    public void setDadosMonitoramento(Set<DadosMonitoramentoDTO> dadosMonitoramento) {
        this.dadosMonitoramento = dadosMonitoramento;
    }
}
