package com.soluflow.app.DTO;

import com.soluflow.app.dominio.usuario.Papel;

import java.io.Serial;
import java.io.Serializable;

public class UsuarioResponseDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Papel papel;

    public UsuarioResponseDTO() {
    }
    public UsuarioResponseDTO(Long id, String name, Papel papel) {
        this.id = id;
        this.name = name;
        this.papel = papel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Papel getPapel() {
        return papel;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }
}
