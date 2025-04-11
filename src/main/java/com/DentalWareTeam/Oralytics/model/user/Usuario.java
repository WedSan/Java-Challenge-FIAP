package com.DentalWareTeam.Oralytics.model.user;

import com.DentalWareTeam.Oralytics.model.AnaliseDentaria;
import com.DentalWareTeam.Oralytics.model.DadoMonitoramento;
import com.DentalWareTeam.Oralytics.model.HistoricoDental;
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

    @Column(name = "ROLE")
    private String role;

    @OneToMany(mappedBy = "usuario")
    private Set<AnaliseDentaria> analisesDentarias;

    @OneToMany(mappedBy = "usuario")
    private Set<DadoMonitoramento> dadosMonitoramento;

    @OneToMany(mappedBy = "usuario")
    private Set<HistoricoDental> historicosDentais;

    public Usuario() {
    }

    public Usuario(Integer id, String nome, String email, String senha, String genero, String role) {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
