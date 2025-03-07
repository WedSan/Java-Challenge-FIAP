package com.DentalWareTeam.Oralytics.services;

import com.DentalWareTeam.Oralytics.dto.AdicionarDadosMonitoramentoDTO;
import com.DentalWareTeam.Oralytics.dto.DadosMonitoramentoDTO;
import com.DentalWareTeam.Oralytics.exceptions.DadoMonitoramentoNotFoundException;
import com.DentalWareTeam.Oralytics.model.DadoMonitoramento;
import com.DentalWareTeam.Oralytics.model.Usuario;
import com.DentalWareTeam.Oralytics.repositories.DadoMonitoramentoRepository;
import com.DentalWareTeam.Oralytics.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DadoMonitoramentoService {

    @Autowired
    private DadoMonitoramentoRepository dadoMonitoramentoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper modelMapper;

    public DadoMonitoramentoService(DadoMonitoramentoRepository dadoMonitoramentoRepository, ModelMapper modelMapper, UsuarioRepository usuarioRepository) {
        this.dadoMonitoramentoRepository = dadoMonitoramentoRepository;
        this.modelMapper = modelMapper;
        this.usuarioRepository = usuarioRepository;
    }

    public DadosMonitoramentoDTO convertToDTO(DadoMonitoramento dadosMonitoramento) {
        return modelMapper.map(dadosMonitoramento, DadosMonitoramentoDTO.class);
    }

    public DadoMonitoramento convertToEntity(DadosMonitoramentoDTO dadosMonitoramentoDTO) {
        return modelMapper.map(dadosMonitoramentoDTO, DadoMonitoramento.class);
    }

    private DadoMonitoramento convertToEntity(AdicionarDadosMonitoramentoDTO dadosMonitoramentoDTO) {
        DadoMonitoramento dadoMonitoramento = new DadoMonitoramento();
        Usuario usuario = usuarioRepository.findById(dadosMonitoramentoDTO.getUsuarioId()).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
        dadoMonitoramento.setUsuario(usuario);
        dadoMonitoramento.setDataRegistro(LocalDateTime.now());

        return dadoMonitoramento;
    }

    public List<DadosMonitoramentoDTO> listarDadosMonitoramento() {
        List<DadoMonitoramento> dadosMonitoramento = dadoMonitoramentoRepository.findAll();
        return dadosMonitoramento.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public DadosMonitoramentoDTO lerDadoMonitoramento(Integer id) throws EntityNotFoundException {
        Optional<DadoMonitoramento> dadoMonitoramento = dadoMonitoramentoRepository.findById(id);
        if (dadoMonitoramento.isPresent()) {
            DadoMonitoramento dadoExistente = dadoMonitoramento.get();
            return convertToDTO(dadoExistente);
        }else {
            throw new EntityNotFoundException("Dado de Monitoramento não encontrado com o ID: " + id);
        }
    }

    public DadosMonitoramentoDTO salvarDadoMonitoramento(AdicionarDadosMonitoramentoDTO dadosMonitoramentoDTO) {
        DadoMonitoramento dadoMonitoramento = convertToEntity(dadosMonitoramentoDTO);
        DadoMonitoramento dadoSalvo = dadoMonitoramentoRepository.save(dadoMonitoramento);
        return convertToDTO(dadoSalvo);
    }

    public void apagarDadosMonitoramento(Integer id) {
        DadosMonitoramentoDTO dadoMonitoramento = lerDadoMonitoramento(id);
        dadoMonitoramentoRepository.deleteById(id);
    }


}