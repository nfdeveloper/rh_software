package io.github.nfdeveloper.rh_software.web.dtos.mappers;

import io.github.nfdeveloper.rh_software.entities.models.Usuario;
import io.github.nfdeveloper.rh_software.web.dtos.usuario.UsuarioCreateDTO;
import org.modelmapper.ModelMapper;

public class UsuarioMapper {

    public static Usuario toUsuario(UsuarioCreateDTO dto){
        return new ModelMapper().map(dto, Usuario.class);
    }
}
