package com.DentalWareTeam.Oralytics.service;

import com.DentalWareTeam.Oralytics.dto.AdicionarRelatoProblemaDentarioDTO;
import com.DentalWareTeam.Oralytics.dto.RelatoProblemaDentarioDTO;
import com.DentalWareTeam.Oralytics.model.RelatoProblemaDentario;
import com.DentalWareTeam.Oralytics.repositories.RelatoProblemaDentarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RelatoProblemaDentarioService {

    @Autowired
    private RelatoProblemaDentarioRepository relatoProblemaDentarioRepository;

    public RelatoProblemaDentarioDTO convertToDTO (RelatoProblemaDentario relatoProblemaDentario) {
        RelatoProblemaDentarioDTO relatoProblemaDentarioDTO = new RelatoProblemaDentarioDTO();
        relatoProblemaDentarioDTO.setId(relatoProblemaDentario.getId());
        relatoProblemaDentarioDTO.setProblema(relatoProblemaDentario.getProblema());
        return relatoProblemaDentarioDTO;
    }

    public RelatoProblemaDentario convertToEntity (AdicionarRelatoProblemaDentarioDTO adicionarRelatoProblemaDentarioDTO) {
        RelatoProblemaDentario relatoProblemaDentario = new RelatoProblemaDentario();
        relatoProblemaDentario.setProblema(adicionarRelatoProblemaDentarioDTO.getProblema());
        relatoProblemaDentario.setDadoMonitoramento(adicionarRelatoProblemaDentarioDTO.getDadoMonitoramento());
        return relatoProblemaDentario;
    }

    public List<RelatoProblemaDentarioDTO> listarTodosRelatos() {
        List<RelatoProblemaDentario> relatosProblemasDentarios = relatoProblemaDentarioRepository.findAll();
        return relatosProblemasDentarios.stream().map(this:: convertToDTO).collect(Collectors.toList());
    }

    public RelatoProblemaDentarioDTO encontrarRelatoPorId(Integer id) {
        Optional<RelatoProblemaDentario> relatoProblemaDentario = relatoProblemaDentarioRepository.findById(id);
        if (relatoProblemaDentario.isPresent()) {
            return convertToDTO(relatoProblemaDentario.get());
        } else {
            throw new EntityNotFoundException("Relato de Problema Dentário não encontrado");
        }
    }

    public RelatoProblemaDentarioDTO salvarRelato(AdicionarRelatoProblemaDentarioDTO adicionarRelatoProblemaDentarioDTO) {
        RelatoProblemaDentario relatoProblemaDentario = convertToEntity(adicionarRelatoProblemaDentarioDTO);
        RelatoProblemaDentario relatoSalvo = relatoProblemaDentarioRepository.save(relatoProblemaDentario);
        return convertToDTO(relatoSalvo);
    }

    public void excluirRelato(Integer id) {
        if (!relatoProblemaDentarioRepository.existsById(id)) {
            throw new RuntimeException("Relato não encontrado");
        }
        relatoProblemaDentarioRepository.deleteById(id);
    }
}
