package com.soluflow.app.repositorio;

import com.soluflow.app.dominio.agendamento.Agendamento;
import com.soluflow.app.dominio.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepositorio extends JpaRepository<Agendamento,Long> {
}
