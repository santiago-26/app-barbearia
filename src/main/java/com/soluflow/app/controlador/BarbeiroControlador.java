package com.soluflow.app.controlador;

import com.soluflow.app.dominio.usuario.Barbeiro;
import com.soluflow.app.dominio.usuario.Usuario;
import com.soluflow.app.servico.BarbeiroServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios/barbeiro")
public class BarbeiroControlador {

    @Autowired
    private BarbeiroServico servico;

    @GetMapping
    public ResponseEntity<List<Barbeiro>> findAll() {
        List<Barbeiro> list = servico.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Barbeiro> findById(@PathVariable Long id) {
        Barbeiro obj = servico.findByid(id);
        return ResponseEntity.ok().body(obj);
    }

}