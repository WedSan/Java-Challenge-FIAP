package com.DentalWareTeam.Oralytics.model;

import com.DentalWareTeam.Oralytics.model.user.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "TB_DADO_MONITORAMENTO")
public class DadoMonitoramento extends RepresentationModel<DadoMonitoramento> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "id_usuario")
    @ManyToOne
    @NotNull
    private Usuario usuario;

    @OneToMany(mappedBy = "dadoMonitoramento", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RelatoProblemaDentario> relatosProblemasDentarios;

    private LocalDateTime dataRegistro;

    @JoinTable(name = "TB_DADO_MONITORAMENTO_ANALISE_DENTARIA",
            joinColumns = @JoinColumn(name = "id_dado_monitoramento"),
            inverseJoinColumns = @JoinColumn(name = "id_analise_dentaria"))
    @ManyToMany
    private Set<AnaliseDentaria> analisesDentarias;

    public DadoMonitoramento() {
    }

    public DadoMonitoramento(Integer id, Usuario usuario, Set<RelatoProblemaDentario> relatosProblemasDentarios, LocalDateTime dataRegistro, Set<AnaliseDentaria> analisesDentarias) {
        this.id = id;
        this.usuario = usuario;
        this.relatosProblemasDentarios = relatosProblemasDentarios;
        this.dataRegistro = dataRegistro;
        this.analisesDentarias = analisesDentarias;
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
        this.relatosProblemasDentarios = relatosProblemasDentarios;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Set<AnaliseDentaria> getAnalisesDentarias() {
        return analisesDentarias;
    }

    public void setAnalisesDentarias(Set<AnaliseDentaria> analisesDentarias) {
        this.analisesDentarias = analisesDentarias;
    }
}
