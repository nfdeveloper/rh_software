package io.github.nfdeveloper.rh_software.services;

import io.github.nfdeveloper.rh_software.entities.models.Funcionario;
import io.github.nfdeveloper.rh_software.entities.models.Marcacao;
import io.github.nfdeveloper.rh_software.exceptions.EntityNotFoundException;
import io.github.nfdeveloper.rh_software.jwt.JwtUserDetailsService;
import io.github.nfdeveloper.rh_software.respositories.MarcacaoRepository;
import io.github.nfdeveloper.rh_software.web.dtos.mappers.MarcacaoMapper;
import io.github.nfdeveloper.rh_software.web.dtos.marcacao.MarcacaoCreateDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MarcacaoService {

    @Autowired
    private MarcacaoRepository repository;
    @Autowired
    private JwtUserDetailsService jwtService;

    private Marcacao buscar(Long id){
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Marcação não encontrada.")
        );
    }

    private Marcacao buscarPorFuncionario(Long id, Funcionario funcionario){
        return repository.findByIdAndFuncionario(id, funcionario).orElseThrow(
                () -> new EntityNotFoundException("Marcação não encontrada ou não pertence ao Funcionário.")
        );
    }

    public List<Marcacao> listar(HttpServletRequest request){
        return repository.findByFuncionario(jwtService.findUsuarioByToken(request).getFuncionario());
    }

    @Transactional
    public Marcacao criar(MarcacaoCreateDTO dto, HttpServletRequest request){
        Marcacao marcacao = MarcacaoMapper.toMarcacao(dto);
        marcacao.setFuncionario(jwtService.findUsuarioByToken(request).getFuncionario());
        return repository.save(marcacao);
    }

    public Marcacao buscarPorId(Long id, HttpServletRequest request){
        return buscarPorFuncionario(id, jwtService.findUsuarioByToken(request).getFuncionario());
    }

    @Transactional
    public void remover(Long id, HttpServletRequest request){
        Marcacao marcacao =  buscarPorFuncionario(id, jwtService.findUsuarioByToken(request).getFuncionario());
        repository.delete(marcacao);
    }
}
