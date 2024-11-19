package io.github.nfdeveloper.rh_software.services;

import io.github.nfdeveloper.rh_software.entities.enums.Role;
import io.github.nfdeveloper.rh_software.entities.models.Usuario;
import io.github.nfdeveloper.rh_software.exceptions.EntityNotFoundException;
import io.github.nfdeveloper.rh_software.respositories.UsuarioRepository;
import io.github.nfdeveloper.rh_software.web.dtos.mappers.UsuarioMapper;
import io.github.nfdeveloper.rh_software.web.dtos.usuario.UsuarioCreateDTO;
import io.github.nfdeveloper.rh_software.web.dtos.usuario.UsuarioResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private Usuario buscar(Long id){
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Usuário não encontrado.")
        );
    }

    public List<Usuario> listar(){
        return repository.findAll();
    }

    @Transactional
    public UsuarioResponseDTO criar(UsuarioCreateDTO dto){
        Usuario usuario = UsuarioMapper.toUsuario(dto);
        usuario.setPassword(passwordEncoder.encode(dto.getPassword()));
        return UsuarioMapper.toDto(repository.save(usuario));
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
        return repository.findByUsername(username).orElseThrow(
                () -> new EntityNotFoundException("Usuário não encontrado.")
        );
    }

    public Role buscarRolePorUsename(String username) {
        return repository.findRoleByUsername(username);
    }
}
