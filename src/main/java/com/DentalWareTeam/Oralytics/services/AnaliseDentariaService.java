package com.DentalWareTeam.Oralytics.services;

import com.DentalWareTeam.Oralytics.dto.AdicionarAnaliseDentariaDTO;
import com.DentalWareTeam.Oralytics.dto.AnaliseDentariaDTO;
import com.DentalWareTeam.Oralytics.model.AnaliseDentaria;
import com.DentalWareTeam.Oralytics.model.DadoMonitoramento;
import com.DentalWareTeam.Oralytics.repositories.AnaliseDentariaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AnaliseDentariaService {

    @Autowired
    private AnaliseDentariaRepository analiseDentariaRepository;

    @Autowired
    private DadoMonitoramentoService dadoMonitoramentoService;

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

    public AnaliseDentaria lerAnaliseDentaria (Integer id) throws EntityNotFoundException{
        Optional<AnaliseDentaria> analiseDentaria = analiseDentariaRepository.findById(id);
        if (analiseDentaria.isPresent()){
            return analiseDentaria.get();
        }else {
            throw new EntityNotFoundException("Análise Dentária não encontrada");
        }

    }

    public AnaliseDentariaDTO salvarAnaliseDentaria(AdicionarAnaliseDentariaDTO analiseDentariaDTO) {
        AnaliseDentaria analise = convertToEntity(analiseDentariaDTO);

        analise.setDataAnalise(LocalDateTime.now());

        Set<DadoMonitoramento> dadoMonitoramentos = new LinkedHashSet<>();
        analiseDentariaDTO.getDadosMonitoramentoIds().forEach(id -> {
            dadoMonitoramentos.add(dadoMonitoramentoService.lerDadoMonitoramento(id));
        });
        analise.setDadosMonitoramento(dadoMonitoramentos);

        AnaliseDentaria analiseSalva = analiseDentariaRepository.save(analise);
        return convertToDTO(analiseSalva);
    }

    private AnaliseDentariaDTO convertToDTO(AnaliseDentaria analiseDentaria) {
        return modelMapper.map(analiseDentaria, AnaliseDentariaDTO.class);
    }

    private AnaliseDentaria convertToEntity(AnaliseDentariaDTO analiseDentariaDTO) {
        return modelMapper.map(analiseDentariaDTO, AnaliseDentaria.class);
    }

    private AnaliseDentaria convertToEntity(AdicionarAnaliseDentariaDTO analiseDentariaDTO) {
        return modelMapper.map(analiseDentariaDTO, AnaliseDentaria.class);
    }

    public void apagarAnaliseDentaria(Integer id) {
        AnaliseDentaria analiseDentaria = lerAnaliseDentaria(id);
        analiseDentariaRepository.delete(analiseDentaria);
    }
}
