package io.github.nfdeveloper.rh_software.web.dtos.usuario;

import io.github.nfdeveloper.rh_software.entities.models.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponseDTO {
    private Long id;
    private String username;
    private String permissao;
    private Funcionario funcionario;
}
