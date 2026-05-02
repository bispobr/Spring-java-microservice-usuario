package com.microservice.usuario.services;

import com.microservice.usuario.models.UsuarioModel;
import com.microservice.usuario.producers.UsuarioProducer;
import com.microservice.usuario.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.mockito.MockitoAnnotations;



import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class UsuarioServiceTest {

    @InjectMocks
    private UsuarioService usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private UsuarioProducer usuarioProducer;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveSalvarUsuarioEPublicarMensagem() {

        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome("Teste");
        usuario.setEmail("teste@email.com");

        when(usuarioRepository.save(any(UsuarioModel.class))).thenReturn(usuario);


        UsuarioModel salvo = usuarioService.Salvar(usuario);


        assertNotNull(salvo);
        assertEquals("Teste", salvo.getNome());
        verify(usuarioRepository, times(1)).save(usuario);
        verify(usuarioProducer, times(1)).publicarMensagemEmail(usuario);
    }

}