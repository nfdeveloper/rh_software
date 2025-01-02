package io.github.nfdeveloper.rh_software.web.controllers;

import io.github.nfdeveloper.rh_software.entities.models.Funcionario;
import io.github.nfdeveloper.rh_software.services.FuncionarioService;
import io.github.nfdeveloper.rh_software.web.dtos.funcionario.FuncionarioCreateDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/funcionarios")
@CrossOrigin("*")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping("{id}")
    @PreAuthorize("hasRole('TI') OR #id == authentication.principal.id")
    public ResponseEntity<Funcionario> buscar(@PathVariable Long id, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id, request));
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> listar(HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(service.listar(request));
    }

    @PostMapping
    public ResponseEntity<Funcionario> criar(@RequestBody FuncionarioCreateDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Funcionario> remover(@PathVariable Long id, HttpServletRequest request){
        service.remover(id, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
