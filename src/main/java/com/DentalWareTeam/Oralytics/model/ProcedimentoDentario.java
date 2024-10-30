package com.DentalWareTeam.Oralytics.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Entity
@Table(name = "TB_PROCEDIMENTO_DENTARIO")
public class ProcedimentoDentario extends RepresentationModel<ProcedimentoDentario> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String procedimento;

    @JoinColumn(name = "ID_HISTORICO_DENTAL")
    @ManyToOne
    private HistoricoDental historicoDental;

    public ProcedimentoDentario() {
    }

    public ProcedimentoDentario(Integer id, String procedimento, HistoricoDental historicoDental) {
        this.id = id;
        this.procedimento = procedimento;
        this.historicoDental = historicoDental;
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

    public HistoricoDental getHistoricoDental() {
        return historicoDental;
    }

    public void setHistoricoDental(HistoricoDental historicoDental) {
        this.historicoDental = historicoDental;
    }
}
