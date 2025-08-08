package com.soluflow.app.dominio.agendamento;

import com.soluflow.app.dominio.cliente.Cliente;
import com.soluflow.app.dominio.servico.Servico;
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
    private Instant moment;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;
    @ManyToOne(optional = false)
    @JoinColumn(name = "servico_id", nullable = false)
    private Servico servico;
    private Status statusAgendamento;
    private Origem origemAgendamento;

    public Agendamento() {
    }

    public Agendamento(Long id, Instant moment, Cliente cliente, Funcionario funcionario, Servico servico, Status statusAgendamento, Origem origemAgendamento) {
        this.id = id;
        this.moment = moment;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.servico = servico;
        this.statusAgendamento = statusAgendamento;
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

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }
    public Status getStatusAgendamento() {
        return statusAgendamento;
    }

    public void setStatusAgendamento(Status statusAgendamento) {
        this.statusAgendamento = statusAgendamento;
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
