package com.DentalWareTeam.Oralytics.model;

public class Usuario {

    private int id;
    private String name;
    private String email;
    private String senha;
    private char genero;

    public Usuario() {
    }

    public Usuario(int id, String name, String email, String senha, char genero) {
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
