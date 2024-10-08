package com.DentalWareTeam.Oralytics.dto;

import jakarta.validation.constraints.NotNull;

public class AtualizacaoSenhaDTO {

    @NotNull(message = "O campo de nova senha não pode ser nula")
    private String novaSenha;

    public AtualizacaoSenhaDTO() {
    }

    public AtualizacaoSenhaDTO(String novaSenha) {
        this.novaSenha = novaSenha;
    }

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }
}
