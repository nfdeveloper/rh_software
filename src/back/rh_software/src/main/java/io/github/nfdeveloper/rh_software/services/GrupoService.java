package io.github.nfdeveloper.rh_software.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.nfdeveloper.rh_software.entities.models.Grupo;
import io.github.nfdeveloper.rh_software.respositories.GrupoRepository;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository repository;

    private Grupo buscar(Long id){
        return repository.findById(id).get();
    }

    public List<Grupo> listar(){
        return repository.findAll();
    }

    @Transactional
    public Grupo criar(Grupo grupo){
        return repository.save(grupo);
    }

    public Grupo buscarPorId(Long id){
        return buscar(id);
    }

    @Transactional
    public void remover(Long id){
        Grupo grupo = buscar(id);
        repository.delete(grupo);
    }
}
