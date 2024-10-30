package com.DentalWareTeam.Oralytics.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.hateoas.RepresentationModel;

public class UsuarioDTO extends RepresentationModel<UsuarioDTO> {

    private int id;

    @NotBlank(message = "O campo de nome não pode ser nulo")
    private String name;

    @Email
    @NotBlank(message = "O campo de email não pode ser nulo")
    private String email;


    @NotBlank(message = "O campo de senha não pode ser nulo")
    private String senha;

    @NotNull(message = "O campo de genero não pode ser nulo")
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
