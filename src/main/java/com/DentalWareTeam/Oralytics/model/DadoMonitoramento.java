package com.DentalWareTeam.Oralytics.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "TB_DADO_MONITORAMENTO")
public class DadoMonitoramento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "id_usuario")
    @ManyToOne
    @NotNull
    private Usuario usuario;

    @OneToMany(mappedBy = "dadosMonitoramento", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RelatoProblemaDentario> relatosProblemasDentarios;

    private LocalDateTime dataRegistro;

    @JoinTable(name = "TB_DADO_MONITORAMENTO_ANALISE_DENTARIA",
            joinColumns = @JoinColumn(name = "id_dado_monitoramento"),
            inverseJoinColumns = @JoinColumn(name = "id_analise_dentaria"))
    @ManyToMany
    private Set<AnaliseDentaria> analisesDentarios;

    public DadoMonitoramento() {
    }

    public DadoMonitoramento(Integer id, Usuario usuario, Set<RelatoProblemaDentario> relatosProblemasDentarios, LocalDateTime dataRegistro) {
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

    public  Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario (Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<RelatoProblemaDentario> getRelatosProblemasDentarios() {
        return relatosProblemasDentarios;
    }

    public void setRelatosProblemasDentarios(Set<RelatoProblemaDentario> relatosProblemasDentarios) {
        relatosProblemasDentarios.forEach(relato -> relato.setDadosMonitoramento(this));
        this.relatosProblemasDentarios = relatosProblemasDentarios;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Set<AnaliseDentaria> getAnalisesDentarios() {
        return analisesDentarios;
    }

    public void setAnalisesDentarios(Set<AnaliseDentaria> analisesDentarios) {
        this.analisesDentarios = analisesDentarios;
    }
}
