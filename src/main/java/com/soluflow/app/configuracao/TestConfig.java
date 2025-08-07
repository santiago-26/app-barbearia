package com.soluflow.app.configuracao;

import com.soluflow.app.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
}
