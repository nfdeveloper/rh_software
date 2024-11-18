package io.github.nfdeveloper.rh_software.web.dtos.mappers;

import io.github.nfdeveloper.rh_software.entities.models.Marcacao;
import io.github.nfdeveloper.rh_software.web.dtos.marcacao.MarcacaoCreateDTO;
import org.modelmapper.ModelMapper;

public class MarcacaoMapper {

    public static Marcacao toMarcacao(MarcacaoCreateDTO dto){
        return new ModelMapper().map(dto, Marcacao.class);
    }
}
