package io.github.nfdeveloper.rh_software.services;

import io.github.nfdeveloper.rh_software.entities.models.Usuario;
import io.github.nfdeveloper.rh_software.respositories.UsuarioRepository;
import io.github.nfdeveloper.rh_software.web.dtos.mappers.UsuarioMapper;
import io.github.nfdeveloper.rh_software.web.dtos.usuario.UsuarioCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    private Usuario buscar(Long id){
        return repository.findById(id).get();
    }

    public List<Usuario> listar(){
        return repository.findAll();
    }

    @Transactional
    public Usuario criar(UsuarioCreateDTO dto){
        return repository.save(UsuarioMapper.toUsuario(dto));
    }

    public Usuario buscarPorId(Long id){
        return buscar(id);
    }

    @Transactional
    public void remover(Long id){
        Usuario usuario = buscar(id);
        repository.delete(usuario);
    }

    public Usuario buscarPorUsername(String username){
        return repository.findByUsername(username).get();
    }
}
