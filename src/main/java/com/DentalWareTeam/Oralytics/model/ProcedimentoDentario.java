package com.DentalWareTeam.Oralytics.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "TB_PROCEDIMENTO_DENTARIO")
public class ProcedimentoDentario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Max(50)
    private String procedimento;

    @OneToMany(mappedBy = "procedimentoDentario")
    private List<HistoricoDental> historicoDental;

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

    public List<HistoricoDental> getHistoricoDental() {
        return historicoDental;
    }

    public void setHistoricoDental(List<HistoricoDental> historicoDental) {
        this.historicoDental = historicoDental;
    }
}
