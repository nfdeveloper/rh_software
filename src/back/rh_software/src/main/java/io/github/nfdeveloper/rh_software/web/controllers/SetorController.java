package io.github.nfdeveloper.rh_software.web.controllers;

import io.github.nfdeveloper.rh_software.entities.models.Setor;
import io.github.nfdeveloper.rh_software.services.SetorService;
import io.github.nfdeveloper.rh_software.web.dtos.setor.SetorCreateDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/setores")
public class SetorController {

    @Autowired
    private SetorService service;

    @GetMapping
    public ResponseEntity<List<Setor>> listar(HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(service.listar(request));
    }

    @GetMapping("{id}")
    public ResponseEntity<Setor> buscar(@PathVariable Long id, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id, request));
    }

    @PostMapping
    public ResponseEntity<Setor> criar(@RequestBody SetorCreateDTO dto, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto, request));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Setor> remover(@PathVariable Long id, HttpServletRequest request){
        service.remover(id, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
