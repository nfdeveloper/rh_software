package io.github.nfdeveloper.rh_software.web.dtos.mappers;

import org.modelmapper.ModelMapper;

import io.github.nfdeveloper.rh_software.entities.models.Empresa;
import io.github.nfdeveloper.rh_software.web.dtos.empresa.EmpresaCreateDTO;

public class EmpresaMapper {

    public static Empresa toEmpresa(EmpresaCreateDTO dto){
        return new ModelMapper().map(dto, Empresa.class);
    }
}
