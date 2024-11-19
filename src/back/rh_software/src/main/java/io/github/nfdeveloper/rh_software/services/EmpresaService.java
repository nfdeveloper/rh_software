package io.github.nfdeveloper.rh_software.services;

import java.util.List;

import io.github.nfdeveloper.rh_software.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.nfdeveloper.rh_software.entities.models.Empresa;
import io.github.nfdeveloper.rh_software.respositories.EmpresaRepository;
import io.github.nfdeveloper.rh_software.web.dtos.empresa.EmpresaCreateDTO;
import io.github.nfdeveloper.rh_software.web.dtos.mappers.EmpresaMapper;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    private Empresa buscar(Long id){
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Empresa não encontrada.")
        );
    }

    public List<Empresa> listar(){
        return repository.findAll();
    }

    @Transactional
    public Empresa criar(EmpresaCreateDTO dto){
        return repository.save(EmpresaMapper.toEmpresa(dto));
    }
    
    public Empresa buscarPorId(Long id){
        return buscar(id);
    }

    @Transactional
    public void remover(Long id){
        Empresa empresa = buscar(id);
        repository.delete(empresa);
    }
}
