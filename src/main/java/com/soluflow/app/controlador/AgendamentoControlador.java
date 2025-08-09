package com.soluflow.app.controlador;

import com.soluflow.app.dominio.agendamento.Agendamento;
import com.soluflow.app.servico.AgendamentoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/agendamento")
public class AgendamentoControlador {

    @Autowired
    private AgendamentoServico servico;

    @GetMapping
    public ResponseEntity<List<Agendamento>> findAll() {
        List<Agendamento> list = servico.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Agendamento> findById(@PathVariable Long id) {
        Agendamento obj = servico.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}