package io.github.nfdeveloper.rh_software.web.dtos.funcao;

import io.github.nfdeveloper.rh_software.entities.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FuncaoCreateDTO {

    private Long id;
    private String nome;
    private String descricao;
    private Double horasSemana;
    private Double horasDia;
    private Double horasIntervalo;
    private Status status = Status.ATIVO;
}
