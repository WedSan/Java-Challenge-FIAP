package consumer;

import com.DentalWareTeam.Oralytics.dto.UsuarioDTO;
import com.DentalWareTeam.Oralytics.model.LogCadastro;
import com.DentalWareTeam.Oralytics.repositories.LogCadastroRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class LogConsumer {

    @Autowired
    private LogCadastroRepository logCadastroRepository;

    @RabbitListener(queues = "cadastro.concluido")
    public void salvarLogCadastro(UsuarioDTO usuario) {
        LogCadastro log = new LogCadastro();
        log.setNomeUsuario(usuario.getNome());
        log.setEmailUsuario(usuario.getEmail());
        log.setDataCadastro(LocalDateTime.now());

        logCadastroRepository.save(log);
        System.out.println("Log de cadastro salvo no banco.");

    }
}
