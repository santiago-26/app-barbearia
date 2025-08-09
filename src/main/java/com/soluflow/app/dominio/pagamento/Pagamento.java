package com.soluflow.app.dominio.pagamento;

import com.soluflow.app.dominio.Pedido.Pedido;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_pagamento")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;
    @OneToOne
    @MapsId
    private Pedido pedido;
    private MetodoPagamento metodoPagamento;
    private Integer statusPagamento;

    public Pagamento() {
    }

    public Pagamento(Long id, Instant moment, Pedido pedido, MetodoPagamento metodoPagamento, StatusPagamento statusPagamento) {
        this.id = id;
        this.moment = moment;
        this.pedido = pedido;
        this.metodoPagamento = metodoPagamento;
        setStatusPagamento(statusPagamento);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public StatusPagamento getStatusPagamento() {
        return StatusPagamento.valueOf(statusPagamento);
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        if (statusPagamento != null) {
            this.statusPagamento = statusPagamento.getCode();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
