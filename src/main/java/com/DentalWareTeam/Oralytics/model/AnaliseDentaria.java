package com.DentalWareTeam.Oralytics.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "TB_ANALISE_DENTARIA")
public class AnaliseDentaria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @JoinColumn(name = "id_usuario")
    @ManyToOne
    @NotNull
    private Usuario usuario;

    @NotNull
    private Date dataAnalise;

    @NotNull
    @Max(5)
    private double probabilidadeProblema;


    public AnaliseDentaria() {
    }

    public AnaliseDentaria(Integer id, Usuario usuario, Date dataAnalise, double probabilidadeProblema) {
        this.id = id;
        this.usuario = usuario;
        this.dataAnalise = dataAnalise;
        this.probabilidadeProblema = probabilidadeProblema;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(@NotNull Usuario usuario) {
        this.usuario = usuario;
    }

    public @NotNull Date getDataAnalise() {
        return dataAnalise;
    }

    public void setDataAnalise(@NotNull Date dataAnalise) {
        this.dataAnalise = dataAnalise;
    }

    @NotNull
    @Max(5)
    public double getProbabilidadeProblema() {
        return probabilidadeProblema;
    }

    public void setProbabilidadeProblema(@NotNull @Max(5) double probabilidadeProblema) {
        this.probabilidadeProblema = probabilidadeProblema;
    }
}
