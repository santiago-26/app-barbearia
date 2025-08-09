package com.soluflow.app.servico;

import com.soluflow.app.dominio.servico.Oficio;
import com.soluflow.app.repositorio.OficioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OficioServico {

    @Autowired
    private OficioRepositorio repositorio;

    public List<Oficio> findAll(){
        return repositorio.findAll();
    }

    public Oficio findById(Long id){
        Optional<Oficio> obj = repositorio.findById(id);
        return obj.get();
    }

}
