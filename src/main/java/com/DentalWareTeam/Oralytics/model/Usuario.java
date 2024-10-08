package com.DentalWareTeam.Oralytics.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

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

    @OneToMany(mappedBy = "usuario")
    private List<HistoricoDental> historicos;

    @OneToMany(mappedBy = "usuario")
    private List<DadoMonitoramento> dadosMonitoramento;

    @OneToMany(mappedBy = "usuario")
    private List<AnaliseDentaria> analiseDentaria;

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

    public @NotNull @Max(120) String getName() {
        return name;
    }

    public void setName(@NotNull @Max(120) String name) {
        this.name = name;
    }

    public @NotNull @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotNull @Email String email) {
        this.email = email;
    }

    public @NotNull @Max(255) String getSenha() {
        return senha;
    }

    public void setSenha(@NotNull @Max(255) String senha) {
        this.senha = senha;
    }

    @NotNull
    @Max(1)
    public char getGenero() {
        return genero;
    }

    public void setGenero(@NotNull @Max(1) char genero) {
        this.genero = genero;
    }

    public List<HistoricoDental> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(List<HistoricoDental> historicos) {
        this.historicos = historicos;
    }

    public List<DadoMonitoramento> getDadosMonitoramento() {
        return dadosMonitoramento;
    }

    public void setDadosMonitoramento(List<DadoMonitoramento> dadosMonitoramento) {
        this.dadosMonitoramento = dadosMonitoramento;
    }

    public List<AnaliseDentaria> getAnaliseDentaria() {
        return analiseDentaria;
    }

    public void setAnaliseDentaria(List<AnaliseDentaria> analiseDentaria) {
        this.analiseDentaria = analiseDentaria;
    }
}
