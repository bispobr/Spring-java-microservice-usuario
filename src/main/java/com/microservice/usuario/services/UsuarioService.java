package com.microservice.usuario.services;

import com.microservice.usuario.models.UsuarioModel;
import com.microservice.usuario.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Transactional
    public UsuarioModel Salvar(UsuarioModel usuarioModel){
        usuarioModel = usuarioRepository.save(usuarioModel);
        return usuarioModel;
    }
}
