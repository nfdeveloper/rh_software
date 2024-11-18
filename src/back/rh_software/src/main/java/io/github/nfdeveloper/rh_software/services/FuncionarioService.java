package io.github.nfdeveloper.rh_software.services;

import io.github.nfdeveloper.rh_software.entities.models.Funcionario;
import io.github.nfdeveloper.rh_software.respositories.FuncionarioRepository;
import io.github.nfdeveloper.rh_software.web.dtos.funcionario.FuncionarioCreateDTO;
import io.github.nfdeveloper.rh_software.web.dtos.mappers.FuncionarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    private Funcionario buscar(Long id){
        return repository.findById(id).get();
    }

    public List<Funcionario> listar(){
        return repository.findAll();
    }

    @Transactional
    public Funcionario criar(FuncionarioCreateDTO dto){
        return repository.save(FuncionarioMapper.toFuncionario(dto));
    }

    public Funcionario buscarPorId(Long id){
        return buscar(id);
    }

    @Transactional
    public void remover(Long id){
        Funcionario funcionario = buscar(id);
        repository.delete(funcionario);
    }
}
