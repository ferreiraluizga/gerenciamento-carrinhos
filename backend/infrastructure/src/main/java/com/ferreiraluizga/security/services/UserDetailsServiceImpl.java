package com.ferreiraluizga.security.services;

import com.ferreiraluizga.entities.Usuario;
import com.ferreiraluizga.exceptions.usuario.UsuarioNaoEncontrado;
import com.ferreiraluizga.security.UsuarioSecurityDetails;
import com.ferreiraluizga.usecases.usuario.BuscarUsuarioPorEmailUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final BuscarUsuarioPorEmailUseCase buscarUsuarioPorEmailUseCase;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            Usuario usuario = buscarUsuarioPorEmailUseCase.execute(email);
            return new UsuarioSecurityDetails(usuario);
        } catch (UsuarioNaoEncontrado e) {
            throw new UsernameNotFoundException("Usuário não encontrado: " + email, e);
        }
    }
}
