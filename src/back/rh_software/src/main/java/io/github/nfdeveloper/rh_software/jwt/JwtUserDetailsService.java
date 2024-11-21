package io.github.nfdeveloper.rh_software.jwt;

import io.github.nfdeveloper.rh_software.entities.models.Grupo;
import io.github.nfdeveloper.rh_software.entities.models.Usuario;
import io.github.nfdeveloper.rh_software.services.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.buscarPorUsername(username);
        return new JwtUserDetails(usuario);
    }

    public JwtToken getTokenAuthenticated(String username){
        Usuario usuario = usuarioService.buscarPorUsername(username);
        String token = JwtUtils.createToken(username, usuario.getPermissao().name());
        return new JwtToken(token, usuario.getUsername(), usuario.getPermissao().name());
    }

    public Usuario findUsuarioByToken(HttpServletRequest request){
        String token = request.getHeader("Authorization").substring(JwtUtils.JWT_BEARER.length());
        return usuarioService.buscarPorUsername(JwtUtils.getUsernameFromToken(token));
    }

    public Grupo findGrupoByToken(HttpServletRequest request){
        String token = request.getHeader("Authorization").substring(JwtUtils.JWT_BEARER.length());
        return usuarioService.buscarPorUsername(JwtUtils.getUsernameFromToken(token)).getFuncionario().getEmpresa().getGrupo();
    }
}
