package com.DentalWareTeam.Oralytics.dto;

import java.util.Date;

public class DadosMonitoramentoDTO {

    private Integer id;
    private Integer idUsuario;
    private Integer idRelatoProblemaDentario;
    private Date dataRegistro;

    public DadosMonitoramentoDTO() {

    }

    public DadosMonitoramentoDTO(Integer id, Integer idUsuario, Integer idRelatoProblemaDentario, Date dataRegistro) {
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

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
}
