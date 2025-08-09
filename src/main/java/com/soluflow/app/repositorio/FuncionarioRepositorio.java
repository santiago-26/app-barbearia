package com.soluflow.app.repositorio;

import com.soluflow.app.dominio.usuario.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepositorio extends JpaRepository<Funcionario,Long> {
}
