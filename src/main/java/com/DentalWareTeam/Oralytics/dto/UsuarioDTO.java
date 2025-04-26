package com.DentalWareTeam.Oralytics.dto;

import com.DentalWareTeam.Oralytics.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Set;

public class UsuarioDTO {

    private int id;

    @NotBlank(message = "O campo de nome não pode ser nulo")
    private String nome;

    @Email
    @NotBlank(message = "O campo de email não pode ser nulo")
    private String email;


    @NotBlank(message = "O campo de senha não pode ser nulo")
    private String senha;

    @NotNull(message = "O campo de genero não pode ser nulo")
    private String genero;

    @NotNull(message = "O campo de role não pode ser nulo")
    private Set<Role> roles;

    public UsuarioDTO() {

    }

    public UsuarioDTO(int id, String nome, String email, String senha, String genero, Set<Role> roles) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.genero = genero;
        this.roles = roles;
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

    public @NotBlank(message = "O campo de senha não pode ser nulo") String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "O campo de senha não pode ser nulo") String senha) {
        this.senha = senha;
    }

    public @NotNull(message = "O campo de genero não pode ser nulo") String getGenero() {
        return genero;
    }

    public void setGenero(@NotNull(message = "O campo de genero não pode ser nulo") String genero) {
        this.genero = genero;
    }

    public @NotNull(message = "O campo de role não pode ser nulo") Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(@NotNull(message = "O campo de role não pode ser nulo") Set<Role> roles) {
        this.roles = roles;
    }
}
