package com.DentalWareTeam.Oralytics.dto;

import jakarta.validation.constraints.NotBlank;

public class AdicionarRelatoProblemaDentarioDTO {

    @NotBlank(message = "o campo de problema não pode ser nulo")
    private String problema;

    public AdicionarRelatoProblemaDentarioDTO() {
    }

    public AdicionarRelatoProblemaDentarioDTO(String problema) {
        this.problema = problema;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }
}
