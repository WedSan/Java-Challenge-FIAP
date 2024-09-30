package com.DentalWareTeam.Oralytics.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_RELATO_PROBLEMA_DENTARIO")
public class RelatoProblemaDentario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String problema;

    public RelatoProblemaDentario() {
    }

    public RelatoProblemaDentario(Integer id, String problema) {
        this.id = id;
        this.problema = problema;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }
}
