package com.DentalWareTeam.Oralytics.services;

import com.DentalWareTeam.Oralytics.dto.DadosMonitoramentoDTO;
import com.DentalWareTeam.Oralytics.exceptions.DadoMonitoramentoNotFoundException;
import com.DentalWareTeam.Oralytics.model.DadoMonitoramento;
import com.DentalWareTeam.Oralytics.repositories.DadoMonitoramentoRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DadoMonitoramentoService {

    @Autowired
    private DadoMonitoramentoRepository dadoMonitoramentoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public DadoMonitoramentoService(DadoMonitoramentoRepository dadoMonitoramentoRepository, ModelMapper modelMapper) {
        this.dadoMonitoramentoRepository = dadoMonitoramentoRepository;
        this.modelMapper = modelMapper;
    }

    private DadosMonitoramentoDTO convertToDTO(DadoMonitoramento dadosMonitoramento) {
        return modelMapper.map(dadosMonitoramento, DadosMonitoramentoDTO.class);
    }

    private DadoMonitoramento convertToEntity(DadosMonitoramentoDTO dadosMonitoramentoDTO) {
        return modelMapper.map(dadosMonitoramentoDTO, DadoMonitoramento.class);
    }

    public List<DadosMonitoramentoDTO> listarDadosMonitoramento() {
        List<DadoMonitoramento> dadosMonitoramento = dadoMonitoramentoRepository.findAll();
        return dadosMonitoramento.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public DadosMonitoramentoDTO lerDadoMonitoramento(Integer id) throws DadoMonitoramentoNotFoundException {
        Optional<DadoMonitoramento> dadoMonitoramento = dadoMonitoramentoRepository.findById(id);
        if (dadoMonitoramento.isPresent()) {
            return convertToDTO(dadoMonitoramento.get());
        }else {
            throw new DadoMonitoramentoNotFoundException("Dado de Monitoramento não encontrado com o ID: " + id);
        }
    }

    public DadosMonitoramentoDTO salvarDadoMonitoramento(DadosMonitoramentoDTO dadosMonitoramentoDTO) {
        DadoMonitoramento dadoMonitoramento = convertToEntity(dadosMonitoramentoDTO);
        DadoMonitoramento dadoSalvo = dadoMonitoramentoRepository.save(dadoMonitoramento);
        return convertToDTO(dadoSalvo);
    }


}