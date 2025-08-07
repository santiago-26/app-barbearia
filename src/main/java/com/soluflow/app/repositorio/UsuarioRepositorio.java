package com.soluflow.app.repositorio;

import com.soluflow.app.dominio.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {
}
