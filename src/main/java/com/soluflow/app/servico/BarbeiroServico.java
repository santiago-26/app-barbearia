package com.soluflow.app.servico;

import com.soluflow.app.dominio.usuario.Funcionario;

import com.soluflow.app.repositorio.BarbeiroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarbeiroServico {

    @Autowired
    private BarbeiroRepositorio repositorio;

    public List<Funcionario> findAll(){
        return repositorio.findAll();
    }

    public Funcionario findByid(Long id){
        Optional<Funcionario> obj = repositorio.findById(id);
        return obj.get();
    }
}
