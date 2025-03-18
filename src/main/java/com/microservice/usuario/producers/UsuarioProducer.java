package com.microservice.usuario.producers;

import com.microservice.usuario.dtos.EmailDto;
import com.microservice.usuario.models.UsuarioModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UsuarioProducer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Value(value = "${broker.queue.email.name}")
    private String chaveRoteamento;

    public void publicarMensagemEmail(UsuarioModel usuarioModel) {
        var emailDto = new EmailDto();
        emailDto.setUsuarioId(usuarioModel.getUsuarioId());
        emailDto.setEmailDestinatario(usuarioModel.getEmail());
        emailDto.setAssunto("Cadastro realizado com sucesso!");
        emailDto.setMensagem(usuarioModel.getNome() + ", seja bem vindo(a)! \nAgradecemos o seu cadastro, aproveite agora todos os recursos da nossa plataforma!");

        rabbitTemplate.convertAndSend("", chaveRoteamento, emailDto);
    }

}
