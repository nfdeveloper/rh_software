package io.github.nfdeveloper.rh_software.jwt;

import io.github.nfdeveloper.rh_software.entities.enums.Role;
import io.github.nfdeveloper.rh_software.entities.models.Usuario;
import io.github.nfdeveloper.rh_software.services.UsuarioService;
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
        Role role = usuarioService.buscarRolePorUsename(username);
        return JwtUtils.createToken(username, role.name());
    }
}
