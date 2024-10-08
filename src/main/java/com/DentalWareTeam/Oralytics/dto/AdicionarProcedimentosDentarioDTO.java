package com.DentalWareTeam.Oralytics.dto;

import jakarta.validation.constraints.NotBlank;

public class AdicionarProcedimentosDentarioDTO {

    @NotBlank(message = "o campo de procedimento não pode ser nulo")
    private String procedimento;

    public AdicionarProcedimentosDentarioDTO() {
    }

    public AdicionarProcedimentosDentarioDTO(String procedimento) {
        this.procedimento = procedimento;
    }

    public String getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(String procedimento) {
        this.procedimento = procedimento;
    }
}
