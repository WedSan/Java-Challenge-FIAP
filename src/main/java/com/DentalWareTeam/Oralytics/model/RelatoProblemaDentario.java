package com.DentalWareTeam.Oralytics.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_RELATO_PROBLEMA_DENTARIO")
public class RelatoProblemaDentario {

    @Id
    private int id;
    private String problema;

    public RelatoProblemaDentario() {
    }

    public RelatoProblemaDentario(int id, String problema) {
        this.id = id;
        this.problema = problema;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }
}
