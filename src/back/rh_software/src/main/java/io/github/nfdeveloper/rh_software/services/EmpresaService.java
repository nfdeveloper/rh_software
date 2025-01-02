package io.github.nfdeveloper.rh_software.services;

import java.util.List;

import io.github.nfdeveloper.rh_software.entities.enums.PorteEmpresa;
import io.github.nfdeveloper.rh_software.entities.models.Grupo;
import io.github.nfdeveloper.rh_software.entities.models.Usuario;
import io.github.nfdeveloper.rh_software.exceptions.EntityNotFoundException;
import io.github.nfdeveloper.rh_software.jwt.JwtUserDetailsService;
import jakarta.servlet.http.HttpServletRequest;
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
    @Autowired
    private JwtUserDetailsService jwtService;

    private Empresa buscar(Long id){
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Empresa não encontrada.")
        );
    }

    private Empresa buscarPorGrupo(Long id, Grupo grupo){
        return repository.findByIdAndGrupo(id, grupo).orElseThrow(
                () -> new EntityNotFoundException("Empresa não encontrada ou não pertence a esse grupo.")
        );
    }

    private PorteEmpresa validarPortePorQuantidadeFuncionario(Long quantidade){
        if(quantidade >= 10 && quantidade <= 99){
            return PorteEmpresa.PEQUENO_PORTE;
        }
        else if(quantidade >= 100 && quantidade <= 499){
            return PorteEmpresa.MEDIO_PORTE;
        }
        else {
            return PorteEmpresa.GRANDE_PORTE;
        }
    }

    public List<Empresa> listar(HttpServletRequest request){
        return repository.findByGrupo(jwtService.findGrupoByToken(request));
    }

    @Transactional
    public Empresa criar(HttpServletRequest request, EmpresaCreateDTO dto){
        Empresa empresa = EmpresaMapper.toEmpresa(dto);
        empresa.setPorte(validarPortePorQuantidadeFuncionario(dto.getQuantidadeFuncionarios()));
        empresa.setGrupo(jwtService.findGrupoByToken(request));
        return repository.save(empresa);
    }
    
    public Empresa buscarPorId(Long id, HttpServletRequest request){
        return buscarPorGrupo(id,jwtService.findGrupoByToken(request));
    }

    @Transactional
    public void remover(Long id, HttpServletRequest request){
        Empresa empresa = buscarPorGrupo(id, jwtService.findGrupoByToken(request));
        repository.delete(empresa);
    }
}
