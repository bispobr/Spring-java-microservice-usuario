package com.microservice.usuario.dtos;

import java.util.UUID;

public record UsuarioResponseDTO(UUID usuarioId,String nome,String email) {
}
