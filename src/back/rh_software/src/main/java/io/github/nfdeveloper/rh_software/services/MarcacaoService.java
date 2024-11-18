package io.github.nfdeveloper.rh_software.services;

import io.github.nfdeveloper.rh_software.entities.models.Marcacao;
import io.github.nfdeveloper.rh_software.respositories.MarcacaoRepository;
import io.github.nfdeveloper.rh_software.web.dtos.mappers.MarcacaoMapper;
import io.github.nfdeveloper.rh_software.web.dtos.marcacao.MarcacaoCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MarcacaoService {

    @Autowired
    private MarcacaoRepository repository;

    private Marcacao buscar(Long id){
        return repository.findById(id).get();
    }

    public List<Marcacao> listar(){
        return repository.findAll();
    }

    @Transactional
    public Marcacao criar(MarcacaoCreateDTO dto){
        return repository.save(MarcacaoMapper.toMarcacao(dto));
    }

    public Marcacao buscarPorId(Long id){
        return buscar(id);
    }

    @Transactional
    public void remover(Long id){
        Marcacao marcacao =  buscar(id);
        repository.delete(marcacao);
    }
}
