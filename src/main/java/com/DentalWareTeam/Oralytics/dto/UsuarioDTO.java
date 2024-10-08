package com.DentalWareTeam.Oralytics.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

public class UsuarioDTO {

    private int id;

    @NotNull
    @Max(120)
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Max(255)
    private String senha;

    @NotNull
    @Max(1)
    private char genero;

    public UsuarioDTO() {

    }

    public UsuarioDTO(int id, String name, String email, String senha, char genero) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.senha = senha;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }
}
