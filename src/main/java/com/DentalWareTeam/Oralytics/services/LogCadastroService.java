package com.DentalWareTeam.Oralytics.services;

import com.DentalWareTeam.Oralytics.dto.UsuarioDTO;
import com.DentalWareTeam.Oralytics.model.LogCadastro;
import com.DentalWareTeam.Oralytics.model.Usuario;
import com.DentalWareTeam.Oralytics.repositories.LogCadastroRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class LogCadastroService {

    private final LogCadastroRepository logCadastroRepository;

    public LogCadastroService(LogCadastroRepository logCadastroRepository) {
        this.logCadastroRepository = logCadastroRepository;
    }

    public LogCadastro salvarLogCadastro (UsuarioDTO usuarioDTO){
        LogCadastro logCadastro = new LogCadastro();
        logCadastro.setNomeUsuario(usuarioDTO.getNome());
        logCadastro.setEmailUsuario(usuarioDTO.getEmail());
        logCadastro.setDataCadastro(LocalDateTime.now());
        return logCadastroRepository.save(logCadastro);
    }
}
