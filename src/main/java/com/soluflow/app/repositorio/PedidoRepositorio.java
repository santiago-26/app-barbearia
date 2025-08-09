package com.soluflow.app.repositorio;

import com.soluflow.app.dominio.Pedido.Pedido;
import com.soluflow.app.dominio.servico.Oficio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepositorio extends JpaRepository<Pedido,Long> {
}
