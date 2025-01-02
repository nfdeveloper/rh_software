package io.github.nfdeveloper.rh_software.web.controllers;

import io.github.nfdeveloper.rh_software.entities.models.Empresa;
import io.github.nfdeveloper.rh_software.services.EmpresaService;
import io.github.nfdeveloper.rh_software.web.dtos.empresa.EmpresaCreateDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/empresas")
@CrossOrigin("*")
public class EmpresaController {

    @Autowired
    private EmpresaService service;

    @GetMapping
    public ResponseEntity<List<Empresa>> listar(HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(service.listar(request));
    }

    @GetMapping("{id}")
    public ResponseEntity<Empresa> buscar(@PathVariable Long id, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id, request));
    }

    @PostMapping
    public ResponseEntity<Empresa> criar(@RequestBody EmpresaCreateDTO dto, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(request,dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Empresa> remover(@PathVariable Long id, HttpServletRequest request){
        service.remover(id, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
