package com.DentalWareTeam.Oralytics.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_PROCEDIMENTO_DENTARIO")
public class ProcedimentoDentario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String procedimento;

    public ProcedimentoDentario() {
    }

    public ProcedimentoDentario(Integer id, String procedimento) {
        this.id = id;
        this.procedimento = procedimento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(String procedimento) {
        this.procedimento = procedimento;
    }
}
