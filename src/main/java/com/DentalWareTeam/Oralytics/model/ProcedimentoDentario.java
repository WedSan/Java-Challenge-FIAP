package com.DentalWareTeam.Oralytics.model;

public class ProcedimentoDentario {

    private int id;

    private String procedimento;

    public ProcedimentoDentario() {
    }

    public ProcedimentoDentario(int id, String procedimento) {
        this.id = id;
        this.procedimento = procedimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(String procedimento) {
        this.procedimento = procedimento;
    }
}
