package com.soluflow.app.controlador;

import com.soluflow.app.dominio.Pedido.Pedido;
import com.soluflow.app.dominio.cliente.Cliente;
import com.soluflow.app.servico.ClienteServico;
import com.soluflow.app.servico.PedidoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoControlador {

    @Autowired
    private PedidoServico servico;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        List<Pedido> list = servico.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Long id) {
        Pedido obj = servico.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}