package com.microservice.usuario.Controllers;

import com.microservice.usuario.dtos.UsuarioRecordDto;
import com.microservice.usuario.dtos.UsuarioResponseDTO;
import com.microservice.usuario.models.UsuarioModel;
import com.microservice.usuario.services.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import com.microservice.usuario.mapper.UsuarioModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Controller
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UsuarioModelMapper mapper;

    @PostMapping("/usuario")
    @Operation(description = "Endpoint responsável por cadastrar novos Usuários")
    @ApiResponse(responseCode = "201", description = "Usuário cadastrado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro de Requisição, dados enviados não atendem os requisitos")
    @ApiResponse(responseCode = "500", description = "Erro interno")
    public ResponseEntity<UsuarioResponseDTO> salvarUsuario(@RequestBody @Valid UsuarioRecordDto usuarioRecordDto) {
        log.info("Solicitação de Cadastro de Usuário recebida");
        var usuarioModel = new UsuarioModel();
        BeanUtils.copyProperties(usuarioRecordDto, usuarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.paraRespostaDTO(usuarioService.Salvar(usuarioModel))); }

}
