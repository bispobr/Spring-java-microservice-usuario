package com.microservice.usuario.mapper;

import com.microservice.usuario.dtos.UsuarioResponseDTO;
import com.microservice.usuario.models.UsuarioModel;
import org.springframework.stereotype.Component;

@Component
public class UsuarioModelMapper {
    public  UsuarioResponseDTO paraRespostaDTO (UsuarioModel entidade){
        return  new UsuarioResponseDTO(entidade.getUsuarioId(), entidade.getNome(), entidade.getEmail());
    }
}
