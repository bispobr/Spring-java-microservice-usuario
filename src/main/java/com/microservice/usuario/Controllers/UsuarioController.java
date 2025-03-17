package com.microservice.usuario.Controllers;

import com.microservice.usuario.dtos.UsuarioRecordDto;
import com.microservice.usuario.models.UsuarioModel;
import com.microservice.usuario.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/usuario")
    public ResponseEntity<UsuarioModel> salvarUsuario(@RequestBody @Valid UsuarioRecordDto usuarioRecordDto) {
        var usuarioModel = new UsuarioModel();
        BeanUtils.copyProperties(usuarioRecordDto, usuarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.Salvar(usuarioModel));
    }

}
