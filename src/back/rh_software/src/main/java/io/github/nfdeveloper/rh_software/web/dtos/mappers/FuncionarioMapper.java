package io.github.nfdeveloper.rh_software.web.dtos.mappers;

import io.github.nfdeveloper.rh_software.entities.models.Funcionario;
import io.github.nfdeveloper.rh_software.web.dtos.funcionario.FuncionarioCreateDTO;
import org.modelmapper.ModelMapper;

public class FuncionarioMapper {

    public static Funcionario toFuncionario(FuncionarioCreateDTO dto){
        return new ModelMapper().map(dto, Funcionario.class);
    }
}
