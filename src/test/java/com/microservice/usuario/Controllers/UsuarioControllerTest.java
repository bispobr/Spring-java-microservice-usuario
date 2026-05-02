package com.microservice.usuario.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.usuario.dtos.UsuarioRecordDto;
import com.microservice.usuario.dtos.UsuarioResponseDTO;
import com.microservice.usuario.models.UsuarioModel;
import com.microservice.usuario.services.UsuarioService;
import com.microservice.usuario.mapper.UsuarioModelMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class UsuarioControllerTest {

    @Mock
    private UsuarioService usuarioService;

    @Mock
    private UsuarioModelMapper mapper;


    @InjectMocks
    private UsuarioController usuarioController;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    MockMvc mockMvc;

    private UsuarioRecordDto usuarioRecordDto;
    private UsuarioModel usuarioModel;
    private UsuarioResponseDTO usuarioResponseDTO;


    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(usuarioController).build();
        usuarioRecordDto = new UsuarioRecordDto("Teste", "teste@email.com");
        usuarioModel = new UsuarioModel();
        usuarioModel.setNome("Teste");
        usuarioModel.setEmail("teste@email.com");

        usuarioResponseDTO = new UsuarioResponseDTO(new UUID(10,10),"Teste", "teste@email.com");
    }

    @Test
    void deveCadastrarUsuarioComSucesso() throws Exception {
        when(usuarioService.Salvar(any(UsuarioModel.class))).thenReturn(usuarioModel);
        when(mapper.paraRespostaDTO(any(UsuarioModel.class))).thenReturn(usuarioResponseDTO);

        mockMvc.perform(post("/usuario")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usuarioRecordDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome").value("Teste"))
                .andExpect(jsonPath("$.email").value("teste@email.com"));

        verify(usuarioService, times(1)).Salvar(any(UsuarioModel.class));
        verify(mapper, times(1)).paraRespostaDTO(any(UsuarioModel.class));
    }


}