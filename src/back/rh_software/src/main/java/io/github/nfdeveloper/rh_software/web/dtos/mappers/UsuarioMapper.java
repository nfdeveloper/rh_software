package io.github.nfdeveloper.rh_software.web.dtos.mappers;

import io.github.nfdeveloper.rh_software.entities.models.Usuario;
import io.github.nfdeveloper.rh_software.web.dtos.usuario.UsuarioCreateDTO;
import io.github.nfdeveloper.rh_software.web.dtos.usuario.UsuarioResponseDTO;
import org.modelmapper.ModelMapper;

public class UsuarioMapper {

    public static Usuario toUsuario(UsuarioCreateDTO dto){
        return new ModelMapper().map(dto, Usuario.class);
    }

    public static UsuarioResponseDTO toDto(Usuario usuario){
        return new ModelMapper().map(usuario, UsuarioResponseDTO.class);
    }
}
