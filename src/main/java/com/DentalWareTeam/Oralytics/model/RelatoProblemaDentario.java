package com.DentalWareTeam.Oralytics.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "TB_RELATO_PROBLEMA_DENTARIO")
public class RelatoProblemaDentario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Max(30)
    private String problema;

    @OneToMany(mappedBy = "relatoProblemaDentario")
    private List<DadoMonitoramento> dadosMonitoramento;

    public RelatoProblemaDentario() {
    }

    public RelatoProblemaDentario(Integer id, String problema, List<DadoMonitoramento> dadosMonitoramento) {
        this.id = id;
        this.problema = problema;
        this.dadosMonitoramento = dadosMonitoramento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public List<DadoMonitoramento> getDadosMonitoramento() {
        return dadosMonitoramento;
    }

    public void setDadosMonitoramento(List<DadoMonitoramento> dadosMonitoramento) {
        this.dadosMonitoramento = dadosMonitoramento;
    }
}
