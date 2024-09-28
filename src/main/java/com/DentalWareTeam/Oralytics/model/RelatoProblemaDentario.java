package com.DentalWareTeam.Oralytics.model;

public class RelatoProblemaDentario {

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
