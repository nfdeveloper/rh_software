package io.github.nfdeveloper.rh_software.web.controllers;

import io.github.nfdeveloper.rh_software.services.UsuarioService;
import io.github.nfdeveloper.rh_software.web.dtos.usuario.UsuarioCreateDTO;
import io.github.nfdeveloper.rh_software.web.dtos.usuario.UsuarioResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criar(@RequestBody UsuarioCreateDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
    }
}
