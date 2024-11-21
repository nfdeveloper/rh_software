package io.github.nfdeveloper.rh_software.services;

import java.util.List;

import io.github.nfdeveloper.rh_software.entities.models.Funcao;
import io.github.nfdeveloper.rh_software.entities.models.Grupo;
import io.github.nfdeveloper.rh_software.exceptions.EntityNotFoundException;
import io.github.nfdeveloper.rh_software.jwt.JwtUserDetailsService;
import jakarta.servlet.http.HttpServletRequest;
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
    @Autowired
    private JwtUserDetailsService jwtService;

    private Setor buscar(Long id){
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Setor não encontrado.")
        );
    }

    private Setor buscarPorGrupo(Long id, Grupo grupo){
        return repository.findByIdAndGrupo(id, grupo).orElseThrow(
                () -> new EntityNotFoundException("Função não encontrada ou não pertence a esse grupo.")
        );
    }

    public List<Setor> listar(HttpServletRequest request){
        return repository.findByGrupo(jwtService.findGrupoByToken(request));
    }

    @Transactional
    public Setor criar(SetorCreateDTO dto, HttpServletRequest request){
        Setor setor = SetorMapper.toSetor(dto);
        setor.setGrupo(jwtService.findGrupoByToken(request));
        return repository.save(setor);
    }

    public Setor buscarPorId(Long id, HttpServletRequest request){
        return buscarPorGrupo(id, jwtService.findGrupoByToken(request));
    }

    @Transactional
    public void remover(Long id, HttpServletRequest request){
        Setor setor = buscarPorGrupo(id, jwtService.findGrupoByToken(request));
        repository.delete(setor);
    }
}
