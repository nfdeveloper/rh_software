package io.github.nfdeveloper.rh_software.web.dtos.usuario;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UsuarioLoginDTO {

    private String username;
    private String password;
}
