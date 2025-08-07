package com.soluflow.app.resources;

import com.soluflow.app.entities.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/usuarios")
public class UserResource {

    @GetMapping
    public ResponseEntity<Usuario> findAll() {
        Usuario u = new Usuario(1L, "MAURICIO", "mauricio@mauricio", "7199276", LocalDateTime.now());
        return ResponseEntity.ok().body(u);
    }

}