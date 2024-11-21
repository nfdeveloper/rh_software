package io.github.nfdeveloper.rh_software.services;

import io.github.nfdeveloper.rh_software.entities.models.Empresa;
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

    private Funcionario buscarPorEmpresa(Long id, Empresa empresa){
        return repository.findByIdAndEmpresa(id, empresa).orElseThrow(
                () -> new EntityNotFoundException("Funcionário não encontrado ou não pertence a esse grupo.")
        );
    }

    // TODO - Método para Listagem ADMIN
//    public List<Funcionario> listar(HttpServletRequest request){
//        return repository.findByGrupo(jwtService.findGrupoByToken(request));
//    }

    @Transactional
    public Funcionario criar(FuncionarioCreateDTO dto){
        return repository.save(FuncionarioMapper.toFuncionario(dto));
    }

    public Funcionario buscarPorId(Long id, HttpServletRequest request){
        return buscarPorEmpresa(id, jwtService.findUsuarioByToken(request).getFuncionario().getEmpresa());
    }

    @Transactional
    public void remover(Long id, HttpServletRequest request){
        Funcionario funcionario = buscarPorEmpresa(id, jwtService.findUsuarioByToken(request).getFuncionario().getEmpresa());
        repository.delete(funcionario);
    }
}
