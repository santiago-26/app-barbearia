package com.soluflow.app.repositorio;

import com.soluflow.app.dominio.servico.Oficio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OficioRepositorio extends JpaRepository<Oficio,Long> {
}
