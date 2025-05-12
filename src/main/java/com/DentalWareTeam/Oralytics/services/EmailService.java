package com.DentalWareTeam.Oralytics.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarEmailBoasVindas(String destino, String nome) {
        SimpleMailMessage mensagem = new SimpleMailMessage();
        mensagem.setTo(destino);
        mensagem.setSubject("Bem-vindo!");
        mensagem.setText("Olá " + nome + ", seja bem-vindo ao nosso sistema!");
        mensagem.setFrom("oralyticsproject@gmail.com");

        mailSender.send(mensagem);
    }
}
