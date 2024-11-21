package io.github.nfdeveloper.rh_software.web.controllers;

import io.github.nfdeveloper.rh_software.entities.models.Funcao;
import io.github.nfdeveloper.rh_software.services.FuncaoService;
import io.github.nfdeveloper.rh_software.web.dtos.funcao.FuncaoCreateDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/funcoes")
public class FuncaoController {

    @Autowired
    private FuncaoService service;

    @GetMapping
    public ResponseEntity<List<Funcao>> listar(HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(service.listar(request));
    }

    @GetMapping("{id}")
    public ResponseEntity<Funcao> buscar(@PathVariable Long id, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id, request));
    }

    @PostMapping
    public ResponseEntity<Funcao> criar(@RequestBody FuncaoCreateDTO dto, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto, request));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id, HttpServletRequest request){
        service.remover(id, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
