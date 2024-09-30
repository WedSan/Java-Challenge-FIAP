package com.DentalWareTeam.Oralytics.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_DADO_MONITORAMENTO")
public class DadoMonitoramento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JoinColumn(name = "id_usuario")
    @ManyToOne
    private Usuario usuario;

    @JoinColumn(name = "id_relato_problema_dentario")
    @OneToMany
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
