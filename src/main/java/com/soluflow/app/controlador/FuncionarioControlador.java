package com.soluflow.app.controlador;

import com.soluflow.app.dominio.usuario.Funcionario;
import com.soluflow.app.servico.FuncionarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios/funcionario")
public class FuncionarioControlador {

    @Autowired
    private FuncionarioServico servico;

    @GetMapping
    public ResponseEntity<List<Funcionario>> findAll() {
        List<Funcionario> list = servico.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Funcionario> findById(@PathVariable Long id) {
        Funcionario obj = servico.findByid(id);
        return ResponseEntity.ok().body(obj);
    }

}