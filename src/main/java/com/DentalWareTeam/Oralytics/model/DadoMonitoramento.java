package com.DentalWareTeam.Oralytics.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TB_DADO_MONITORAMENTO")
public class DadoMonitoramento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JoinColumn(name = "id_usuario")
    @ManyToOne
    @NotNull
    private Usuario usuario;

    @JoinColumn(name = "id_relato_problema_dentario")
    @ManyToOne
    private Set<RelatoProblemaDentario> relatosProblemasDentarios;

    @NotNull
    private LocalDate dataRegistro;

    public DadoMonitoramento() {
    }

    public DadoMonitoramento(Integer id, Usuario usuario, Set<RelatoProblemaDentario> relatosProblemasDentarios, LocalDate dataRegistro) {
        this.id = id;
        this.usuario = usuario;
        this.relatosProblemasDentarios = relatosProblemasDentarios;
        this.dataRegistro = dataRegistro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(@NotNull Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<RelatoProblemaDentario> getRelatosProblemasDentarios() {
        return relatosProblemasDentarios;
    }

    public void setRelatosProblemasDentarios(Set<RelatoProblemaDentario> relatosProblemasDentarios) {
        this.relatosProblemasDentarios = relatosProblemasDentarios;
    }

    public @NotNull LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(@NotNull LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
}
