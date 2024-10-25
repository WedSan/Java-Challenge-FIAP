package com.DentalWareTeam.Oralytics.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

public class ProcedimentoDentarioDTO {

    private Integer id;

    @NotNull(message = "o campo de procedimento não pode ser nulo")
    private String procedimento;

    public ProcedimentoDentarioDTO() {

    }

    public ProcedimentoDentarioDTO(Integer id, String procedimento) {
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
