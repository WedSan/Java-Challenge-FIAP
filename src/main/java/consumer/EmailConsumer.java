package consumer;

import com.DentalWareTeam.Oralytics.dto.UsuarioDTO;
import com.DentalWareTeam.Oralytics.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = "cadastro.concluido")
    public void enviarEmailBoasVindas(UsuarioDTO usuario) {
        System.out.println("Usuário recebido da fila: " + usuario.getNome());
        emailService.enviarEmailBoasVindas(usuario.getEmail(), usuario.getNome());

    }
}
