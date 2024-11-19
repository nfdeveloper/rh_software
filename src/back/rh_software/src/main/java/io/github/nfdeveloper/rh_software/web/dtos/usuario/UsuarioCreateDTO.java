package io.github.nfdeveloper.rh_software.web.dtos.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioCreateDTO {

    private Long id;
    private String username;
    private String password;
    private String permissao;
    private Long funcionarioId;
}
