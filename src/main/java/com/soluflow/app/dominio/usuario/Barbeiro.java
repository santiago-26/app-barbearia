package com.soluflow.app.dominio.usuario;

import jakarta.persistence.*;

import java.util.List;

@Entity
@DiscriminatorValue("BARBEIRO")
public class Barbeiro extends Usuario{
    private Boolean disponivel;
    private List<String> especialidades;

    public Barbeiro() {
    }

    public Barbeiro(Long id, String name, String email, String cel, Boolean disponivel, List<String> especialidades) {
        super(id, name, email, cel);
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
        return especialidades;
    }

    public void setEspecialidades(List<String> especialidades) {
        this.especialidades = especialidades;
    }

}
