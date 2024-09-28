package com.DentalWareTeam.Oralytics.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "TB_ANALISE_DENTARIA")
public class AnaliseDentaria {

    @Id
    private int id;
    private int id_usuario;
    private LocalDate data_analise;
    private double probalidade_problema;

    public AnaliseDentaria() {
    }

    public AnaliseDentaria(int id, int id_usuario, LocalDate data_analise, double probalidade_problema) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.data_analise = data_analise;
        this.probalidade_problema = probalidade_problema;
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

    public LocalDate getData_analise() {
        return data_analise;
    }

    public void setData_analise(LocalDate data_analise) {
        this.data_analise = data_analise;
    }

    public double getProbalidade_problema() {
        return probalidade_problema;
    }

    public void setProbalidade_problema(double probalidade_problema) {
        this.probalidade_problema = probalidade_problema;
    }
}