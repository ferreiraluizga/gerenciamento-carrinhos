package com.ferreiraluizga.infrastructure.gateways;

import com.ferreiraluizga.entities.Usuario;
import com.ferreiraluizga.gateways.UsuarioGateway;
import com.ferreiraluizga.infrastructure.mappers.usuario.UsuarioEntityMapper;
import com.ferreiraluizga.infrastructure.persistence.usuario.UsuarioEntity;
import com.ferreiraluizga.infrastructure.persistence.usuario.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UsuarioRepositoryGateway implements UsuarioGateway {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioEntityMapper usuarioEntityMapper;

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        UsuarioEntity response = usuarioRepository.save(usuarioEntityMapper.toEntity(usuario));
        return usuarioEntityMapper.toDomain(response);
    }

    @Override
    public Optional<Usuario> buscarUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .map(usuarioEntityMapper::toDomain);
    }

}
