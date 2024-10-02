package com.DentalWareTeam.Oralytics.dto;

import java.time.LocalDate;
import java.util.Date;

public class DadosMonitoramentoDTO {

    private Integer id;
    private Integer idUsuario;
    private Integer idRelatoProblemaDentario;
    private LocalDate dataRegistro;

    public DadosMonitoramentoDTO() {

    }

    public DadosMonitoramentoDTO(Integer id, Integer idUsuario, Integer idRelatoProblemaDentario, LocalDate dataRegistro) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idRelatoProblemaDentario = idRelatoProblemaDentario;
        this.dataRegistro = dataRegistro;
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

    public Integer getIdRelatoProblemaDentario() {
        return idRelatoProblemaDentario;
    }

    public void setIdRelatoProblemaDentario(Integer idRelatoProblemaDentario) {
        this.idRelatoProblemaDentario = idRelatoProblemaDentario;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
}
