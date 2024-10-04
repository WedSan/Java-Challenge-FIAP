package com.DentalWareTeam.Oralytics.dto;

import com.DentalWareTeam.Oralytics.model.Usuario;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;

public class AnaliseDentariaDTO {

    private Integer id;

    @NotNull
    private Usuario usuario;

    @NotNull
    private LocalDate dataAnalise;

    @NotNull
    @Max(5)
    private double probalidadeProblema;

    public AnaliseDentariaDTO() {

    }

    public AnaliseDentariaDTO(Integer id, Usuario usuario, LocalDate dataAnalise, double probalidadeProblema) {
        this.id = id;
        this.usuario = usuario;
        this.dataAnalise = dataAnalise;
        this.probalidadeProblema = probalidadeProblema;
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

    public void setProbalidadeProblema(double probalidadeProblema) {
        this.probalidadeProblema = probalidadeProblema;
    }

    public LocalDate getDataAnalise() {
        return dataAnalise;
    }

    public void setDataAnalise(LocalDate dataAnalise) {
        this.dataAnalise = dataAnalise;
    }

    public Double getProbalidadeProblema() {
        return probalidadeProblema;
    }

    public void setProbalidadeProblema(Double probalidadeProblema) {
        this.probalidadeProblema = probalidadeProblema;
    }
}
