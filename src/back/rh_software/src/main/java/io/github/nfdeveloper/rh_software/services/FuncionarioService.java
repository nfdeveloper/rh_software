package io.github.nfdeveloper.rh_software.services;

import io.github.nfdeveloper.rh_software.entities.models.Empresa;
import io.github.nfdeveloper.rh_software.entities.models.Funcionario;
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

    private Funcionario calculaImc(Funcionario funcionario){
        double imc = funcionario.getPeso()/(funcionario.getAltura() * funcionario.getAltura());
        if(imc < 18.5){
            funcionario.setImcDescricao("Magreza");
        }
        else if(imc >= 18.5 && imc <= 24.9){
            funcionario.setImcDescricao("Normal");
        }
        else if(imc >= 25 && imc <= 29.9){
            funcionario.setImcDescricao("Sobrepeso");
        }
        else if(imc >= 30 && imc <= 34.9){
            funcionario.setImcDescricao("Obesidade Grau I");
        }
        else if(imc >= 35 && imc <= 39.9){
            funcionario.setImcDescricao("Obesidade Grau II");
        }
        else if(imc >= 40){
            funcionario.setImcDescricao("Obesidade Grau III");
        }

        funcionario.setImc(imc);

        return funcionario;
    }

    // TODO - Método para Listagem ADMIN
    public List<Funcionario> listar(HttpServletRequest request){
        return repository.findByGrupo(jwtService.findGrupoByToken(request));
    }

    @Transactional
    public Funcionario criar(FuncionarioCreateDTO dto){
        Funcionario funcionario = calculaImc(FuncionarioMapper.toFuncionario(dto));
        return repository.save(funcionario);
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
