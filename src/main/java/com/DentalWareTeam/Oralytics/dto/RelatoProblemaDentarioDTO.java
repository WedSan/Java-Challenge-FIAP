package com.DentalWareTeam.Oralytics.dto;

import com.DentalWareTeam.Oralytics.model.DadoMonitoramento;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class RelatoProblemaDentarioDTO {

    private Integer id;

    @NotNull
    private String problema;

    public RelatoProblemaDentarioDTO() {

    }

    public RelatoProblemaDentarioDTO(Integer id, String problema) {
        this.id = id;
        this.problema = problema;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }
}
