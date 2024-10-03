package com.DentalWareTeam.Oralytics.services;

import com.DentalWareTeam.Oralytics.dto.HistoricoDentalDTO;
import com.DentalWareTeam.Oralytics.exceptions.HistoricoDentalNotFoundException;
import com.DentalWareTeam.Oralytics.model.HistoricoDental;
import com.DentalWareTeam.Oralytics.model.ProcedimentoDentario;
import com.DentalWareTeam.Oralytics.model.Usuario;
import com.DentalWareTeam.Oralytics.repositories.HistoricoDentalRepository;
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
    private ModelMapper modelMapper;

    public HistoricoDentalService(HistoricoDentalRepository historicoDentalRepository, ModelMapper modelMapper) {
        this.historicoDentalRepository = historicoDentalRepository;
        this.modelMapper = modelMapper;
    }

    private HistoricoDentalDTO convertToDTO(HistoricoDental historicoDental) {
        return modelMapper.map(historicoDental, HistoricoDentalDTO.class);
    }

    private HistoricoDental convertToEntity(HistoricoDentalDTO historicoDentalDTO) {
        return modelMapper.map(historicoDentalDTO, HistoricoDental.class);
    }

    @Transactional
    public HistoricoDentalDTO salvarHistoricoDental(HistoricoDentalDTO historicoDentalDTO) {
        HistoricoDental historicoDental = convertToEntity(historicoDentalDTO);
        HistoricoDental historicoSalvo = historicoDentalRepository.save(historicoDental);
        return convertToDTO(historicoSalvo);
    }

    public List<HistoricoDentalDTO> listarHistoricoDental() {
        List<HistoricoDental> historicoDentals = historicoDentalRepository.findAll();
        return historicoDentals.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public HistoricoDentalDTO lerHistoricoDental (Integer id) throws HistoricoDentalNotFoundException{
        Optional<HistoricoDental> historicoDental = historicoDentalRepository.findById(id);
        if (historicoDental.isPresent()) {
            return convertToDTO(historicoDental.get());
        }else {
            throw new HistoricoDentalNotFoundException("Histórico Dental não encontrado com o ID "+ id);
        }
    }
}
