package com.soluflow.app.repositorio;

import com.soluflow.app.dominio.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente,Long> {
}
