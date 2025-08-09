package com.soluflow.app.dominio.agendamento;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.soluflow.app.dominio.Pedido.Pedido;
import com.soluflow.app.dominio.cliente.Cliente;
import com.soluflow.app.dominio.servico.Oficio;
import com.soluflow.app.dominio.usuario.Funcionario;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_agendamento")
public class Agendamento implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;
    @ManyToOne(optional = false)
    @JoinColumn(name = "tarefa_id", nullable = false)
    private Oficio oficio;
    private Integer statusAgendamento;
    @Enumerated(EnumType.STRING)
    private Origem origemAgendamento;
    @OneToOne(mappedBy = "agendamento", fetch = FetchType.LAZY)
    private Pedido pedido;


    public Agendamento() {
    }

    public Agendamento(Long id, Instant moment, Cliente cliente, Funcionario funcionario, Oficio oficio, Status statusAgendamento, Origem origemAgendamento) {
        this.id = id;
        this.moment = moment;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.oficio = oficio;
        setStatusAgendamento(statusAgendamento);
        this.origemAgendamento = origemAgendamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Oficio getOficio() {
        return oficio;
    }

    public void setOficio(Oficio oficio) {
        this.oficio = oficio;
    }
    public Status getStatusAgendamento() {
        return Status.valueOf(statusAgendamento);
    }

    public void setStatusAgendamento(Status statusAgendamento) {
        if(statusAgendamento!=null) {
            this.statusAgendamento = statusAgendamento.getCode();
        }
    }

    public Origem getOrigemAgendamento() {
        return origemAgendamento;
    }

    public void setOrigemAgendamento(Origem origemAgendamento) {
        this.origemAgendamento = origemAgendamento;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Agendamento that = (Agendamento) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


}
