package com.DentalWareTeam.Oralytics.model;

public class DadoMonitoramento {

    private int id;
    private int id_usuario;
    private int id_relato_problema_dentario;
    private int data_registro;

    public DadoMonitoramento() {
    }

    public DadoMonitoramento(int id, int id_usuario, int id_relato_problema_dentario, int data_registro) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.id_relato_problema_dentario = id_relato_problema_dentario;
        this.data_registro = data_registro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_relato_problema_dentario() {
        return id_relato_problema_dentario;
    }

    public void setId_relato_problema_dentario(int id_relato_problema_dentario) {
        this.id_relato_problema_dentario = id_relato_problema_dentario;
    }

    public int getData_registro() {
        return data_registro;
    }

    public void setData_registro(int data_registro) {
        this.data_registro = data_registro;
    }
}
