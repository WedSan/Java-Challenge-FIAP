package com.DentalWareTeam.Oralytics.services;

import com.DentalWareTeam.Oralytics.dto.AnaliseDentariaDTO;
import com.DentalWareTeam.Oralytics.model.AnaliseDentaria;
import com.DentalWareTeam.Oralytics.repositories.AnaliseDentariaRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class AnaliseDentariaService {

    @Autowired
    private AnaliseDentariaRepository analiseDentariaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public AnaliseDentariaService(AnaliseDentariaRepository analiseDentariaRepository, ModelMapper modelMapper) {
        this.analiseDentariaRepository = analiseDentariaRepository;
        this.modelMapper = modelMapper;
    }

    public List<AnaliseDentariaDTO> listarAnalisesDentarias() {
        List<AnaliseDentaria> analises = analiseDentariaRepository.findAll();
        return analises.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public AnaliseDentariaDTO salvarAnaliseDentaria(AnaliseDentariaDTO analiseDentariaDTO) {
        AnaliseDentaria analise = convertToEntity(analiseDentariaDTO);
        AnaliseDentaria analiseSalva = analiseDentariaRepository.save(analise);
        return convertToDTO(analiseSalva);
    }

    private AnaliseDentariaDTO convertToDTO(AnaliseDentaria analiseDentaria) {
        return modelMapper.map(analiseDentaria, AnaliseDentariaDTO.class);
    }

    private AnaliseDentaria convertToEntity(AnaliseDentariaDTO analiseDentariaDTO) {
        return modelMapper.map(analiseDentariaDTO, AnaliseDentaria.class);
    }
}
