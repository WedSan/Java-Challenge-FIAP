package com.DentalWareTeam.Oralytics.services;

import com.DentalWareTeam.Oralytics.dto.AdicionarProcedimentosDentarioDTO;
import com.DentalWareTeam.Oralytics.dto.ProcedimentoDentarioDTO;
import com.DentalWareTeam.Oralytics.model.ProcedimentoDentario;
import com.DentalWareTeam.Oralytics.repositories.ProcedimentoDentarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProcedimentoDentarioService {

    @Autowired
    private final ProcedimentoDentarioRepository procedimentoDentarioRepository;

    public ProcedimentoDentarioService(ProcedimentoDentarioRepository procedimentoDentarioRepository) {
        this.procedimentoDentarioRepository = procedimentoDentarioRepository;
    }

    public ProcedimentoDentarioDTO convertToDTO (ProcedimentoDentario procedimentoDentario) {
        ProcedimentoDentarioDTO procedimentoDentarioDTO = new ProcedimentoDentarioDTO();
        procedimentoDentarioDTO.setId(procedimentoDentario.getId());
        procedimentoDentarioDTO.setProcedimento(procedimentoDentario.getProcedimento());
        return  procedimentoDentarioDTO;
    }

    public ProcedimentoDentario convertToEntity (AdicionarProcedimentosDentarioDTO adicionarProcedimentoDentarioDTO) {
        ProcedimentoDentario procedimentoDentario = new ProcedimentoDentario();
        procedimentoDentario.setProcedimento(adicionarProcedimentoDentarioDTO.getProcedimento());
        return procedimentoDentario;
    }

    public List<ProcedimentoDentarioDTO> listarTodosProcedimentos() {
        List<ProcedimentoDentario> procedimentosDentarios = procedimentoDentarioRepository.findAll();
        return procedimentosDentarios.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ProcedimentoDentarioDTO buscarPorId(Integer id) {
        Optional<ProcedimentoDentario> procedimentoDentario = procedimentoDentarioRepository.findById(id);
        if (procedimentoDentario.isPresent()) {
            return convertToDTO(procedimentoDentario.get());
        }else {
            throw new EntityNotFoundException("Procedimento não encontrado");
        }
    }

    public ProcedimentoDentarioDTO salvar(AdicionarProcedimentosDentarioDTO adicionarProcedimentosDentarioDTO) {
        ProcedimentoDentario procedimentoDentario = convertToEntity(adicionarProcedimentosDentarioDTO);
        ProcedimentoDentario procedimentoDentarioSalvo = procedimentoDentarioRepository.save(procedimentoDentario);
        return convertToDTO(procedimentoDentarioSalvo);
    }

    public void excluir(Integer id) {
        if (!procedimentoDentarioRepository.existsById(id)) {
            throw new RuntimeException("Procedimento não encontrado");
        }
        procedimentoDentarioRepository.deleteById(id);
    }
}
