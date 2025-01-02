package io.github.nfdeveloper.rh_software.web.dtos.empresa;

import io.github.nfdeveloper.rh_software.entities.enums.Status;
import io.github.nfdeveloper.rh_software.entities.models.Contato;
import io.github.nfdeveloper.rh_software.entities.models.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaCreateDTO {
    private Long id;
    private String cnpj;
    private String razaoSocial;
    private String fantasia;
    private Endereco endereco;
    private Contato contato;
    private String porte;
    private Long quantidadeFuncionarios;
    private Status status = Status.ATIVO;
}
