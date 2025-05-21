package com.DentalWareTeam.Oralytics.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

public class ListagemUsuarioDTO extends RepresentationModel<ListagemUsuarioDTO> {

    private int id;

    @NotBlank(message = "O campo de nome não pode ser nulo")
    private String nome;

    @Email
    @NotBlank(message = "O campo de email não pode ser nulo")
    private String email;

    @NotBlank(message = "O campo de gênero não pode ser nulo")
    private String genero;

    public ListagemUsuarioDTO() {

    }

    public ListagemUsuarioDTO(int id, String nome, String email, String genero) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.genero = genero;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotBlank(message = "O campo de nome não pode ser nulo") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O campo de nome não pode ser nulo") String nome) {
        this.nome = nome;
    }

    public @Email @NotBlank(message = "O campo de email não pode ser nulo") String getEmail() {
        return email;
    }

    public void setEmail(@Email @NotBlank(message = "O campo de email não pode ser nulo") String email) {
        this.email = email;
    }

    public @NotBlank(message = "O campo de gênero não pode ser nulo") String getGenero() {
        return genero;
    }

    public void setGenero(@NotBlank(message = "O campo de gênero não pode ser nulo") String genero) {
        this.genero = genero;
    }
}
