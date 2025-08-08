package com.soluflow.app.controlador;

import com.soluflow.app.DTO.UsuarioResponseDTO;
import com.soluflow.app.dominio.cliente.Cliente;
import com.soluflow.app.dominio.usuario.Usuario;
import com.soluflow.app.servico.ClienteServico;
import com.soluflow.app.servico.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteControlador {

    @Autowired
    private ClienteServico servico;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        List<Cliente> list = servico.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id) {
        Cliente obj = servico.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}