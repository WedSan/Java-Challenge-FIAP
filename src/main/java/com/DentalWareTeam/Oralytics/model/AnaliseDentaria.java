package com.DentalWareTeam.Oralytics.model;

import com.DentalWareTeam.Oralytics.model.user.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.hateoas.RepresentationModel;


import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "TB_ANALISE_DENTARIA")
public class AnaliseDentaria extends RepresentationModel<AnaliseDentaria> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @JoinColumn(name = "id_usuario")
    @ManyToOne
    private Usuario usuario;

    private LocalDateTime dataAnalise;

    @NotNull
    private double probabilidadeProblema;

    @JoinTable(name = "TB_ANALISE_DENTARIA_DADO_MONITORAMENTO",
            joinColumns = @JoinColumn(name = "id_analise_dentaria"),
            inverseJoinColumns = @JoinColumn(name = "id_dado_monitoramento"))
    @ManyToMany
    private Set<DadoMonitoramento> dadosMonitoramento;


    public AnaliseDentaria() {
    }

    public AnaliseDentaria(Integer id, Usuario usuario, LocalDateTime dataAnalise, double probabilidadeProblema, Set<DadoMonitoramento> dadosMonitoramento) {
        this.id = id;
        this.usuario = usuario;
        this.dataAnalise = dataAnalise;
        this.probabilidadeProblema = probabilidadeProblema;
        this.dadosMonitoramento = dadosMonitoramento;
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

    public LocalDateTime getDataAnalise() {
        return dataAnalise;
    }

    public void setDataAnalise(LocalDateTime dataAnalise) {
        this.dataAnalise = dataAnalise;
    }

    public double getProbabilidadeProblema() {
        return probabilidadeProblema;
    }

    public void setProbabilidadeProblema(double probabilidadeProblema) {
        this.probabilidadeProblema = probabilidadeProblema;
    }

    public Set<DadoMonitoramento> getDadosMonitoramento() {
        return dadosMonitoramento;
    }

    public void setDadosMonitoramento(Set<DadoMonitoramento> dadosMonitoramento) {
        this.dadosMonitoramento = dadosMonitoramento;
    }
}
