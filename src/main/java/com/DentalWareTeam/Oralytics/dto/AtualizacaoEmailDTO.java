package com.DentalWareTeam.Oralytics.dto;

import jakarta.validation.constraints.NotNull;

public class AtualizacaoEmailDTO {

    @NotNull(message = "O campo novo email não pode ser nulo")
    private String novoEmail;

    public AtualizacaoEmailDTO() {
    }

    public AtualizacaoEmailDTO(String novoEmail) {
        this.novoEmail = novoEmail;
    }

    public String getNovoEmail() {
        return novoEmail;
    }

    public void setNovoEmail(String novoEmail) {
        this.novoEmail = novoEmail;
    }
}
