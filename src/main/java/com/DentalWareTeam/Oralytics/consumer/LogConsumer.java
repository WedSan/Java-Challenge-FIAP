package com.DentalWareTeam.Oralytics.consumer;

import com.DentalWareTeam.Oralytics.dto.UsuarioDTO;
import com.DentalWareTeam.Oralytics.model.LogCadastro;
import com.DentalWareTeam.Oralytics.repositories.LogCadastroRepository;
import com.DentalWareTeam.Oralytics.services.LogCadastroService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class LogConsumer {

    private static final String QUEUE_NAME = "cadastro.concluido.queue";

    private final LogCadastroService logCadastroService;

    public LogConsumer(LogCadastroService logCadastroService) {
        this.logCadastroService = logCadastroService;
    }

    @RabbitListener(queues = QUEUE_NAME)
    public void salvarLogCadastro(UsuarioDTO usuarioDTO) {
        LogCadastro logCadastro = new LogCadastro();
        logCadastro.setNomeUsuario(usuarioDTO.getNome());
        logCadastro.setEmailUsuario(usuarioDTO.getEmail());
        logCadastro.setDataCadastro(LocalDateTime.now());
        logCadastroService.salvarLogCadastro(usuarioDTO);
    }
}
