package io.github.nfdeveloper.rh_software.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JwtToken {
    private String token;
    private String usuario;
    private String permisao;
}
