package io.github.nfdeveloper.rh_software.web.dtos.mappers;

import org.modelmapper.ModelMapper;

import io.github.nfdeveloper.rh_software.entities.models.Setor;
import io.github.nfdeveloper.rh_software.web.dtos.setor.SetorCreateDTO;

public class SetorMapper {

    public static Setor toSetor(SetorCreateDTO dto){
        return new ModelMapper().map(dto, Setor.class);
    }
}
