package io.github.nfdeveloper.rh_software.services;

import io.github.nfdeveloper.rh_software.entities.models.Funcao;
import io.github.nfdeveloper.rh_software.entities.models.Funcionario;
import io.github.nfdeveloper.rh_software.entities.models.Grupo;
import io.github.nfdeveloper.rh_software.exceptions.EntityNotFoundException;
import io.github.nfdeveloper.rh_software.jwt.JwtUserDetailsService;
import io.github.nfdeveloper.rh_software.respositories.FuncionarioRepository;
import io.github.nfdeveloper.rh_software.web.dtos.funcionario.FuncionarioCreateDTO;
import io.github.nfdeveloper.rh_software.web.dtos.mappers.FuncionarioMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;
    @Autowired
    private JwtUserDetailsService jwtService;

    private Funcionario buscar(Long id){
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Funcionário não encontrado.")
        );
    }

    private Funcionario buscarPorGrupo(Long id, Grupo grupo){
        return repository.findByIdAndGrupo(id, grupo).orElseThrow(
                () -> new EntityNotFoundException("Funcionário não encontrado ou não pertence a esse grupo.")
        );
    }

    public List<Funcionario> listar(HttpServletRequest request){
        return repository.findByGrupo(jwtService.findGrupoByToken(request));
    }

    @Transactional
    public Funcionario criar(FuncionarioCreateDTO dto){
        return repository.save(FuncionarioMapper.toFuncionario(dto));
    }

    public Funcionario buscarPorId(Long id, HttpServletRequest request){
        return buscarPorGrupo(id, jwtService.findGrupoByToken(request));
    }

    @Transactional
    public void remover(Long id, HttpServletRequest request){
        Funcionario funcionario = buscarPorGrupo(id, jwtService.findGrupoByToken(request));
        repository.delete(funcionario);
    }
}
