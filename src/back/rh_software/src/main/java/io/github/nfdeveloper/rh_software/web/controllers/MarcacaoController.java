package io.github.nfdeveloper.rh_software.web.controllers;

import io.github.nfdeveloper.rh_software.entities.models.Marcacao;
import io.github.nfdeveloper.rh_software.services.MarcacaoService;
import io.github.nfdeveloper.rh_software.web.dtos.marcacao.MarcacaoCreateDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/marcacoes")
public class MarcacaoController {
    
    @Autowired
    private MarcacaoService service;

    @GetMapping
    public ResponseEntity<List<Marcacao>> listar(HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(service.listar(request));
    }

    @GetMapping("{id}")
    public ResponseEntity<Marcacao> buscar(@PathVariable Long id, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id, request));
    }

    @PostMapping
    public ResponseEntity<Marcacao> criar(@RequestBody MarcacaoCreateDTO dto, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto, request));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Marcacao> remover(@PathVariable Long id, HttpServletRequest request){
        service.remover(id, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
