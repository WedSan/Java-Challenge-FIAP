package com.DentalWareTeam.Oralytics.model;

import com.DentalWareTeam.Oralytics.dto.DadosMonitoramentoDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario extends RepresentationModel<Usuario> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOME")
    private String name;

    @Column(name = "EMAIL", unique = true)
    private String email;

    @NotNull
    @Column(name = "SENHA")
    private String senha;

    @Column(name = "GENERO")
    private char genero;

    public Usuario() {
    }

    public Usuario(Integer id, String name, String email, String senha, char genero) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.senha = senha;
        this.genero = genero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(@NotNull @Max(120) String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(@NotNull @Email String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(@NotNull @Max(255) String senha) {
        this.senha = senha;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(@NotNull @Max(1) char genero) {
        this.genero = genero;
    }


}
