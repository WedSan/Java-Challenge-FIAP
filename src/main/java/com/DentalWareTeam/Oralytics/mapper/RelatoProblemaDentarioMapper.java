package com.DentalWareTeam.Oralytics.mapper;

import com.DentalWareTeam.Oralytics.dto.RelatoProblemaDentarioDTO;
import com.DentalWareTeam.Oralytics.model.RelatoProblemaDentario;

import java.util.Set;
import java.util.stream.Collectors;

public class RelatoProblemaDentarioMapper {

    public static RelatoProblemaDentarioDTO toDTO(RelatoProblemaDentario relatoProblemaDentario){
        return new RelatoProblemaDentarioDTO(relatoProblemaDentario.getId(),
                relatoProblemaDentario.getProblema()).add(relatoProblemaDentario.getLinks());
    }

    public static Set<RelatoProblemaDentarioDTO> toDTO(Set<RelatoProblemaDentario> relatoProblemaDentario){
        return relatoProblemaDentario.stream()
                .map(e -> new RelatoProblemaDentarioDTO(e.getId(),
                        e.getProblema()))
                .collect(Collectors.toSet());
    }
}
