package com.DentalWareTeam.Oralytics.model;

import com.DentalWareTeam.Oralytics.model.user.Usuario;
import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "TB_HISTORICO_DENTAL")
public class HistoricoDental extends RepresentationModel<HistoricoDental> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "historicoDental", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProcedimentoDentario> procedimentosDentarios;

    @JoinColumn(name = "id_usuario")
    @ManyToOne
    private Usuario usuario;

    private LocalDateTime dataConsulta;

    private String condicaoDente;

    public HistoricoDental() {
    }

    public HistoricoDental(Integer id, Set<ProcedimentoDentario> procedimentosDentarios, Usuario usuario, LocalDateTime dataConsulta, String condicaoDente) {
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

    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getCondicaoDente() {
        return condicaoDente;
    }

    public void setCondicaoDente(String condicaoDente) {
        this.condicaoDente = condicaoDente;
    }
}
