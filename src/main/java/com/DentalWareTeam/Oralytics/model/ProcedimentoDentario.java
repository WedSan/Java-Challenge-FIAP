package com.DentalWareTeam.Oralytics.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PROCEDIMENTO_DENTARIO")
public class ProcedimentoDentario {

    @Id
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
