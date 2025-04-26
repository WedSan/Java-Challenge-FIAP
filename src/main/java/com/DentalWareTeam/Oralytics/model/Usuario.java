package com.DentalWareTeam.Oralytics.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @ManyToMany
    @JoinTable(name = "TB_USERS_ROLES",
    joinColumns = @JoinColumn(name = "usuario_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "usuario")
    private Set<AnaliseDentaria> analisesDentarias;

    @OneToMany(mappedBy = "usuario")
    private Set<DadoMonitoramento> dadosMonitoramento;

    @OneToMany(mappedBy = "usuario")
    private Set<HistoricoDental> historicosDentais;

    public Usuario() {
    }

    public Usuario(Integer id, String nome, String email, String senha, String genero, Set<Role> roles) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.genero = genero;
        this.roles = roles;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public @NotNull String getSenha() {
        return senha;
    }

    public void setSenha(@NotNull String senha) {
        this.senha = senha;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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
}
