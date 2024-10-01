package com.DentalWareTeam.Oralytics.dto;

import java.time.LocalDate;
import java.util.Date;

public class AnaliseDentariaDTO {

    private Integer id;
    private Integer idUsuario;
    private Date dataAnalise;
    private Double probalidadeProblema;

    public AnaliseDentariaDTO() {

    }

    public AnaliseDentariaDTO(Integer id, Integer idUsuario, Date dataAnalise, Double probalidadeProblema) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.dataAnalise = dataAnalise;
        this.probalidadeProblema = probalidadeProblema;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getDataAnalise() {
        return dataAnalise;
    }

    public void setDataAnalise(Date dataAnalise) {
        this.dataAnalise = dataAnalise;
    }

    public Double getProbalidadeProblema() {
        return probalidadeProblema;
    }

    public void setProbalidadeProblema(Double probalidadeProblema) {
        this.probalidadeProblema = probalidadeProblema;
    }
}
