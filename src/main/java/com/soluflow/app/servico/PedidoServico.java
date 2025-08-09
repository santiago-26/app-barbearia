package com.soluflow.app.servico;

import com.soluflow.app.dominio.Pedido.Pedido;
import com.soluflow.app.dominio.usuario.Usuario;
import com.soluflow.app.repositorio.PedidoRepositorio;
import com.soluflow.app.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServico {

    @Autowired
    private PedidoRepositorio repositorio;

    public List<Pedido> findAll(){
        return repositorio.findAll();
    }

    public Pedido findById(Long id){
        Optional<Pedido> obj = repositorio.findById(id);
        return obj.get();
    }

}
