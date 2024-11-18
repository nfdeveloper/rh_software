package io.github.nfdeveloper.rh_software.web.dtos.mappers;

import io.github.nfdeveloper.rh_software.entities.models.Funcao;
import io.github.nfdeveloper.rh_software.web.dtos.funcao.FuncaoCreateDTO;
import org.modelmapper.ModelMapper;

public class FuncaoMapper {

    public static Funcao toFuncao(FuncaoCreateDTO dto){
        return new ModelMapper().map(dto, Funcao.class);
    }
}
