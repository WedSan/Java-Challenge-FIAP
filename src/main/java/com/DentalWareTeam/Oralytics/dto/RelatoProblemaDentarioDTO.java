package com.DentalWareTeam.Oralytics.dto;

public class RelatoProblemaDentarioDTO {

    private Integer id;
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
