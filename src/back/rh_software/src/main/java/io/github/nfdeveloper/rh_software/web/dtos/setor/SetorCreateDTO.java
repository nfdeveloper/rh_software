package io.github.nfdeveloper.rh_software.web.dtos.setor;

import io.github.nfdeveloper.rh_software.entities.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SetorCreateDTO {

    private Long id;
    private String nome;
    private String descricao;
    private Status status;
}
