package io.github.nfdeveloper.rh_software.services;

import io.github.nfdeveloper.rh_software.entities.models.Funcao;
import io.github.nfdeveloper.rh_software.respositories.FuncaoRepository;
import io.github.nfdeveloper.rh_software.web.dtos.funcao.FuncaoCreateDTO;
import io.github.nfdeveloper.rh_software.web.dtos.mappers.FuncaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FuncaoService {

    @Autowired
    private FuncaoRepository repository;

    private Funcao buscar(Long id){
        return repository.findById(id).get();
    }

    public List<Funcao> listar(){
        return repository.findAll();
    }

    @Transactional
    public Funcao criar(FuncaoCreateDTO dto){
        return repository.save(FuncaoMapper.toFuncao(dto));
    }

    public Funcao buscarPorId(Long id){
        return buscar(id);
    }

    @Transactional
    public void remover(Long id){
        Funcao funcao = buscar(id);
        repository.delete(funcao);
    }
}
