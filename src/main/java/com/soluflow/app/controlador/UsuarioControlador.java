package com.soluflow.app.controlador;

import com.soluflow.app.dto.UsuarioResponseDTO;
import com.soluflow.app.dominio.usuario.Usuario;
import com.soluflow.app.servico.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioControlador {

    @Autowired
    private UsuarioServico servico;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> list = servico.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioResponseDTO> findById(@PathVariable Long id) {
        Usuario obj = servico.findById(id);
        UsuarioResponseDTO dto = new UsuarioResponseDTO(
                obj.getId(),
                obj.getName(),
                obj.getFuncao()
        );
        return ResponseEntity.ok().body(dto);
    }

}