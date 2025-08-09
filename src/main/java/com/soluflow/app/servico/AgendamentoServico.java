package com.soluflow.app.servico;

import com.soluflow.app.dominio.agendamento.Agendamento;
import com.soluflow.app.repositorio.AgendamentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoServico {

    @Autowired
    private AgendamentoRepositorio repositorio;

    public List<Agendamento> findAll(){
        return repositorio.findAll();
    }

    public Agendamento findById(Long id){
        Optional<Agendamento> obj = repositorio.findById(id);
        return obj.get();
    }

}
