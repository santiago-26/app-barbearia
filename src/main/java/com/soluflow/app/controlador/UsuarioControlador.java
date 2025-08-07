package com.soluflow.app.controlador;

import com.soluflow.app.dominio.usuario.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioControlador {

    @GetMapping
    public ResponseEntity<Usuario> findAll() {
        Usuario u = new Usuario(1L, "MAURICIO", "mauricio@mauricio", "7199276");
        return ResponseEntity.ok().body(u);
    }

}