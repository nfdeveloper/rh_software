package io.github.nfdeveloper.rh_software.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.nfdeveloper.rh_software.entities.models.Setor;
import io.github.nfdeveloper.rh_software.respositories.SetorRepository;
import io.github.nfdeveloper.rh_software.web.dtos.mappers.SetorMapper;
import io.github.nfdeveloper.rh_software.web.dtos.setor.SetorCreateDTO;

@Service
public class SetorService {

    @Autowired
    private SetorRepository repository;

    private Setor buscar(Long id){
        return repository.findById(id).get();
    }

    public List<Setor> listar(){
        return repository.findAll();
    }

    @Transactional
    public Setor criar(SetorCreateDTO dto){
        return repository.save(SetorMapper.toSetor(dto));
    }

    public Setor buscarPorId(Long id){
        return buscar(id);
    }

    @Transactional
    public void remover(Long id){
        Setor setor = buscar(id);
        repository.delete(setor);
    }
}
