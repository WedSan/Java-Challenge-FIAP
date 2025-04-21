package com.DentalWareTeam.Oralytics.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "EMAIL", unique = true)
    private String email;

    @NotNull
    @Column(name = "SENHA")
    private String senha;

    @Column(name = "GENERO")
    private String genero;

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE")
    private Role role;

    @OneToMany(mappedBy = "usuario")
    private Set<AnaliseDentaria> analisesDentarias;

    @OneToMany(mappedBy = "usuario")
    private Set<DadoMonitoramento> dadosMonitoramento;

    @OneToMany(mappedBy = "usuario")
    private Set<HistoricoDental> historicosDentais;

    public Usuario() {
    }

    public Usuario(Integer id, String nome, String email, String senha, String genero, Role role) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.genero = genero;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<AnaliseDentaria> getAnalisesDentarias() {
        return analisesDentarias;
    }

    public void setAnalisesDentarias(Set<AnaliseDentaria> analisesDentarias) {
        this.analisesDentarias = analisesDentarias;
    }

    public Set<DadoMonitoramento> getDadosMonitoramento() {
        return dadosMonitoramento;
    }

    public void setDadosMonitoramento(Set<DadoMonitoramento> dadosMonitoramento) {
        this.dadosMonitoramento = dadosMonitoramento;
    }

    public Set<HistoricoDental> getHistoricosDentais() {
        return historicosDentais;
    }

    public void setHistoricosDentais(Set<HistoricoDental> historicosDentais) {
        this.historicosDentais = historicosDentais;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + this.role));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }


}
