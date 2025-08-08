package com.soluflow.app.servico;

import com.soluflow.app.dominio.usuario.Barbeiro;

import com.soluflow.app.repositorio.BarbeiroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarbeiroServico {

    @Autowired
    private BarbeiroRepositorio repositorio;

    public List<Barbeiro> findAll(){
        return repositorio.findAll();
    }

    public Barbeiro findByid(Long id){
        Optional<Barbeiro> obj = repositorio.findById(id);
        return obj.get();
    }
}
