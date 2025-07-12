package com.microservice.usuario.services;

import com.microservice.usuario.models.UsuarioModel;
import com.microservice.usuario.producers.UsuarioProducer;
import com.microservice.usuario.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    UsuarioProducer usuarioProducer;

    @Transactional
    public UsuarioModel Salvar(UsuarioModel usuarioModel){
        usuarioModel = usuarioRepository.save(usuarioModel);
        log.info("Usuario Salvo com sucesso");
        usuarioProducer.publicarMensagemEmail(usuarioModel);
        return usuarioModel;
    }
}
