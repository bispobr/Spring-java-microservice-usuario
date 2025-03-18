package com.microservice.usuario.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter

public class EmailDto {
    private UUID usuarioId;
    private String emailDestinatario;
    private String Assunto;
    private String mensagem;
}
