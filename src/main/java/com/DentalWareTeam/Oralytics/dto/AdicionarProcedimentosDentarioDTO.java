package com.DentalWareTeam.Oralytics.dto;

import com.DentalWareTeam.Oralytics.model.HistoricoDental;
import jakarta.validation.constraints.NotBlank;

public class AdicionarProcedimentosDentarioDTO {

    @NotBlank(message = "o campo de procedimento não pode ser nulo")
    private String procedimento;

    private HistoricoDental historicoDental;

    public AdicionarProcedimentosDentarioDTO() {
    }

    public AdicionarProcedimentosDentarioDTO(String procedimento, HistoricoDental historicoDental) {
        this.procedimento = procedimento;
        this.historicoDental = historicoDental;
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
