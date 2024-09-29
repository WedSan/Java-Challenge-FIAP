package com.DentalWareTeam.Oralytics.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_DADO_MONITORAMENTO")
public class DadoMonitoramento {

    @Id
    private Integer id;
    private Usuario usuario;
    private RelatoProblemaDentario relatoProblemaDentario;
    private int dataRegistro;

    public DadoMonitoramento() {
    }

    public DadoMonitoramento(Integer id, Usuario usuario, RelatoProblemaDentario relatoProblemaDentario, int dataRegistro) {
        this.id = id;
        this.usuario = usuario;
        this.relatoProblemaDentario = relatoProblemaDentario;
        this.dataRegistro = dataRegistro;
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

    public RelatoProblemaDentario getRelatoProblemaDentario() {
        return relatoProblemaDentario;
    }

    public void setRelatoProblemaDentario(RelatoProblemaDentario relatoProblemaDentario) {
        this.relatoProblemaDentario = relatoProblemaDentario;
    }

    public int getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(int dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
}
