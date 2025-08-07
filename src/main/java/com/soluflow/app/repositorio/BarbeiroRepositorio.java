package com.soluflow.app.repositorio;

import com.soluflow.app.dominio.usuario.Barbeiro;
import com.soluflow.app.dominio.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarbeiroRepositorio extends JpaRepository<Barbeiro,Long> {
}
