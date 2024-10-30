package com.DentalWareTeam.Oralytics.mapper;

import com.DentalWareTeam.Oralytics.dto.ProcedimentoDentarioDTO;
import com.DentalWareTeam.Oralytics.model.ProcedimentoDentario;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProcedimentoDentarioMapper {
    public static ProcedimentoDentarioDTO toDTO(ProcedimentoDentario procedimentoDentario){
        return new ProcedimentoDentarioDTO(procedimentoDentario.getId(), procedimentoDentario.getProcedimento()).add(procedimentoDentario.getLinks());
    }

    public static Set<ProcedimentoDentarioDTO> toDTO(Set<ProcedimentoDentario> procedimentosDentarios){
        return procedimentosDentarios.stream()
                .map(ProcedimentoDentarioMapper::toDTO)
                .collect(Collectors.toSet());
    }
}
