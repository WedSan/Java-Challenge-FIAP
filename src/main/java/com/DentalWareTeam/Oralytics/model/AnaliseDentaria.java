package com.DentalWareTeam.Oralytics.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "TB_ANALISE_DENTARIA")
public class AnaliseDentaria {

    @Id
    private Integer id;


    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    private LocalDate dataAnalise;
    private double probabilidadeProblema;

    public AnaliseDentaria() {
    }

    public AnaliseDentaria(Integer id, Usuario usuario, LocalDate dataAnalise, double probabilidadeProblema) {
        this.id = id;
        this.usuario = usuario;
        this.dataAnalise = dataAnalise;
        this.probabilidadeProblema = probabilidadeProblema;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getDataAnalise() {
        return dataAnalise;
    }

    public void setDataAnalise(LocalDate dataAnalise) {
        this.dataAnalise = dataAnalise;
    }

    public double getProbabilidadeProblema() {
        return probabilidadeProblema;
    }

    public void setProbabilidadeProblema(double probabilidadeProblema) {
        this.probabilidadeProblema = probabilidadeProblema;
    }
}
