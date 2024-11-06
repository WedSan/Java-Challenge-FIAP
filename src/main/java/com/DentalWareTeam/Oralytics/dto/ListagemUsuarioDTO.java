package com.DentalWareTeam.Oralytics.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.hateoas.RepresentationModel;

public class ListagemUsuarioDTO extends RepresentationModel<ListagemUsuarioDTO> {

    private int id;

    @NotBlank(message = "O campo de nome não pode ser nulo")
    private String name;

    @Email
    @NotBlank(message = "O campo de email não pode ser nulo")
    private String email;

    public ListagemUsuarioDTO() {

    }

    public ListagemUsuarioDTO(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotBlank(message = "O campo de nome não pode ser nulo") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "O campo de nome não pode ser nulo") String name) {
        this.name = name;
    }

    public @Email @NotBlank(message = "O campo de email não pode ser nulo") String getEmail() {
        return email;
    }

    public void setEmail(@Email @NotBlank(message = "O campo de email não pode ser nulo") String email) {
        this.email = email;
    }
}
