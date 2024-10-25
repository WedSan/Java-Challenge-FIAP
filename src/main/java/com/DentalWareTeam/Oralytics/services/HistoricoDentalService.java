package com.DentalWareTeam.Oralytics.services;

import com.DentalWareTeam.Oralytics.dto.AdicionarHistoricoDentalDTO;
import com.DentalWareTeam.Oralytics.dto.HistoricoDentalDTO;
import com.DentalWareTeam.Oralytics.dto.UsuarioDTO;
import com.DentalWareTeam.Oralytics.exceptions.HistoricoDentalNotFoundException;
import com.DentalWareTeam.Oralytics.mapper.HistoricoDentalMapper;
import com.DentalWareTeam.Oralytics.model.HistoricoDental;
import com.DentalWareTeam.Oralytics.model.ProcedimentoDentario;
import com.DentalWareTeam.Oralytics.model.Usuario;
import com.DentalWareTeam.Oralytics.repositories.HistoricoDentalRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HistoricoDentalService {

    @Autowired
    private final HistoricoDentalRepository historicoDentalRepository;

    @Autowired
    private final UsuarioService usuarioService;

    @Autowired
    private ModelMapper modelMapper;

    public HistoricoDentalService(HistoricoDentalRepository historicoDentalRepository, UsuarioService usuarioService, ModelMapper modelMapper) {
        this.historicoDentalRepository = historicoDentalRepository;
        this.usuarioService = usuarioService;
        this.modelMapper = modelMapper;
    }

    private HistoricoDentalDTO convertToDTO(HistoricoDental historicoDental) {
        return modelMapper.map(historicoDental, HistoricoDentalDTO.class);
    }

    private HistoricoDental convertToEntity(HistoricoDentalDTO historicoDentalDTO) {
        return modelMapper.map(historicoDentalDTO, HistoricoDental.class);
    }

    @Transactional
    public HistoricoDentalDTO salvarHistoricoDental(AdicionarHistoricoDentalDTO historicoDentalDTO) {
        HistoricoDental historicoDental = new HistoricoDental();
        historicoDental.setCondicaoDente(historicoDentalDTO.getCondicaoDente());

        historicoDental.setDataConsulta(historicoDentalDTO.getDataConsulta());

        Usuario usuario =  usuarioService.lerUsuario(historicoDentalDTO.getUsuarioId());
        historicoDental.setUsuario(usuario);

        Set<ProcedimentoDentario> procedimentoDentario = historicoDentalDTO.getProcedimentosDentarios()
                        .stream()
                        .map(procedimentoDentarioDTO -> modelMapper.map(procedimentoDentarioDTO, ProcedimentoDentario.class))
                        .collect(Collectors.toSet());
        historicoDental.setProcedimentosDentarios(procedimentoDentario);

        HistoricoDental historicoSalvo = historicoDentalRepository.save(historicoDental);

        return convertToDTO(historicoSalvo);
    }

    public List<HistoricoDentalDTO> listarHistoricoDental() {
        List<HistoricoDental> historicoDentals = historicoDentalRepository.findAll();
        return historicoDentals.stream()
                .map(HistoricoDentalMapper::toDTO)
                .collect(Collectors.toList());
    }

    public HistoricoDental lerHistoricoDental (Integer id) throws EntityNotFoundException{
        Optional<HistoricoDental> historicoDental = historicoDentalRepository.findById(id);
        if (historicoDental.isPresent()) {
            return historicoDental.get();
        }else {
            throw new EntityNotFoundException("Histórico Dental não encontrado com o ID "+ id);
        }
    }

    public void deletarHistoricoDental(Integer historicoDentalId){
        HistoricoDental historicoDental =  lerHistoricoDental(historicoDentalId);
        historicoDentalRepository.delete(historicoDental);
    }
}
