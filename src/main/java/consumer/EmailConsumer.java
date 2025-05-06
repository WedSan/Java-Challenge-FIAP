package consumer;

import com.DentalWareTeam.Oralytics.dto.UsuarioDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
public class EmailConsumer {

    @RabbitListener(queues = "cadastro.concluido")
    public void enviarEmailBoasVindas(UsuarioDTO usuario) {
        System.out.println("Enviando e-mail para: " + usuario.getEmail());
        System.out.println("Olá " + usuario.getNome() + ", bem vindo ao Oralytics!");
    }
}
