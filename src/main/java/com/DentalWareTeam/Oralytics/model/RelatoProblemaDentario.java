package com.DentalWareTeam.Oralytics.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Entity
@Table(name = "TB_RELATO_PROBLEMA_DENTARIO")
public class RelatoProblemaDentario extends RepresentationModel<RelatoProblemaDentario> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String problema;

    @ManyToOne
    @JoinColumn(name = "id_dado_monitoramento")
    private DadoMonitoramento dadoMonitoramento;

    public RelatoProblemaDentario() {
    }

    public RelatoProblemaDentario(Integer id, String problema, DadoMonitoramento dadoMonitoramento) {
        this.id = id;
        this.problema = problema;
        this.dadoMonitoramento = dadoMonitoramento;
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

    public DadoMonitoramento getDadoMonitoramento() {
        return dadoMonitoramento;
    }

    public void setDadoMonitoramento(DadoMonitoramento dadoMonitoramento) {
        this.dadoMonitoramento = dadoMonitoramento;
    }
}
