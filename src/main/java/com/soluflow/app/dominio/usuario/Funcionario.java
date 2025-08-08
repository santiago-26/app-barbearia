package com.soluflow.app.dominio.usuario;

import com.soluflow.app.dominio.agendamento.Agendamento;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("BARBEIRO")
public class Funcionario extends Usuario{

    private Boolean disponivel;
    @Column(name = "especialidades")
    private String especialidades;

    @OneToMany(mappedBy = "funcionario")
    private List<Agendamento> agendamento = new ArrayList<>();

    public Funcionario() {
    }
    public Funcionario(Long id, String name, String email, String cel, Papel funcao, Boolean disponivel, String especialidades) {
        super(id, name, email, cel, funcao);
        this.disponivel = disponivel;
        this.especialidades = especialidades;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }
    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public List<String> getEspecialidades() {
        if (especialidades == null || especialidades.isBlank()) return List.of();
        return List.of(especialidades.split(","));
    }

    public void setEspecialidades(List<String> lista) {
        this.especialidades = String.join(",", lista);
    }
    public List<Agendamento> getAgendamento() {     return agendamento;    }
}
