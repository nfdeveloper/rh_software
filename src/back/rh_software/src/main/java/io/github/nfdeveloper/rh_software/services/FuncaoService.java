package io.github.nfdeveloper.rh_software.services;

import io.github.nfdeveloper.rh_software.entities.enums.Status;
import io.github.nfdeveloper.rh_software.entities.models.Funcao;
import io.github.nfdeveloper.rh_software.entities.models.Grupo;
import io.github.nfdeveloper.rh_software.exceptions.EntityNotFoundException;
import io.github.nfdeveloper.rh_software.jwt.JwtUserDetailsService;
import io.github.nfdeveloper.rh_software.respositories.FuncaoRepository;
import io.github.nfdeveloper.rh_software.web.dtos.funcao.FuncaoCreateDTO;
import io.github.nfdeveloper.rh_software.web.dtos.mappers.FuncaoMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FuncaoService {

    @Autowired
    private FuncaoRepository repository;
    @Autowired
    private JwtUserDetailsService jwtService;

    private Funcao buscar(Long id){
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Função não encontrada.")
        );
    }

    private Funcao buscarPorGrupo(Long id, Grupo grupo){
        return repository.findByIdAndGrupo(id, grupo).orElseThrow(
                () -> new EntityNotFoundException("Função não encontrada ou não pertence a esse grupo.")
        );
    }

    public List<Funcao> listar(HttpServletRequest request){
        return repository.findByGrupo(jwtService.findGrupoByToken(request));
    }

    public List<Funcao> listarAtivos(HttpServletRequest request){
        return repository.findByGrupoAndStatus(jwtService.findGrupoByToken(request), Status.ATIVO);
    }

    @Transactional
    public Funcao criar(FuncaoCreateDTO dto, HttpServletRequest request){
        Funcao funcao = FuncaoMapper.toFuncao(dto);
        funcao.setGrupo(jwtService.findGrupoByToken(request));
        return repository.save(funcao);
    }

    public Funcao buscarPorId(Long id, HttpServletRequest request){
        return buscarPorGrupo(id, jwtService.findGrupoByToken(request));
    }

    @Transactional
    public void remover(Long id, HttpServletRequest request){
        Funcao funcao = buscarPorGrupo(id, jwtService.findGrupoByToken(request));
        repository.delete(funcao);
    }
}
