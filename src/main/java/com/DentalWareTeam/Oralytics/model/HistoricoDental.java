package com.DentalWareTeam.Oralytics.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "TB_HISTORICO_DENTAL")
public class HistoricoDental {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JoinColumn(name = "id_procedimento_dentario")
    @OneToMany
    private Set<ProcedimentoDentario> procedimentosDentarios;

    @JoinColumn(name = "id_usuario)")
    @ManyToOne
    @NotNull
    private Usuario usuario;

    @NotNull
    private LocalDate dataConsulta;

    @Max(30)
    private String condicaoDente;

    public HistoricoDental() {
    }

    public HistoricoDental(Integer id, Set<ProcedimentoDentario> procedimentosDentarios, Usuario usuario, LocalDate dataConsulta, String condicaoDente) {
        this.id = id;
        this.procedimentosDentarios = procedimentosDentarios;
        this.usuario = usuario;
        this.dataConsulta = dataConsulta;
        this.condicaoDente = condicaoDente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<ProcedimentoDentario> getProcedimentosDentarios() {
        return procedimentosDentarios;
    }

    public void setProcedimentosDentarios(Set<ProcedimentoDentario> procedimentosDentarios) {
        this.procedimentosDentarios = procedimentosDentarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getCondicaoDente() {
        return condicaoDente;
    }

    public void setCondicaoDente(String condicaoDente) {
        this.condicaoDente = condicaoDente;
    }
}
