package com.DentalWareTeam.Oralytics.dto;

import com.DentalWareTeam.Oralytics.model.HistoricoDental;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import org.springframework.hateoas.RepresentationModel;

import java.util.Set;

public class ProcedimentoDentarioDTO extends RepresentationModel<ProcedimentoDentarioDTO> {

    private Integer id;

    @NotNull(message = "o campo de procedimento não pode ser nulo")
    private String procedimento;

    private HistoricoDental historicoDental;

    public ProcedimentoDentarioDTO() {

    }

    public ProcedimentoDentarioDTO(Integer id, String procedimento, HistoricoDental hiistoricoDental) {
        this.id = id;
        this.procedimento = procedimento;
        this.historicoDental = hiistoricoDental;
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
