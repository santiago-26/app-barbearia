package com.soluflow.app.servico;

import com.soluflow.app.dominio.cliente.Cliente;
import com.soluflow.app.dominio.usuario.Usuario;
import com.soluflow.app.repositorio.ClienteRepositorio;
import com.soluflow.app.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServico {

    @Autowired
    private ClienteRepositorio repositorio;

    public List<Cliente> findAll(){
        return repositorio.findAll();
    }

    public Cliente findById(Long id){
        Optional<Cliente> obj = repositorio.findById(id);
        return obj.get();
    }

}
