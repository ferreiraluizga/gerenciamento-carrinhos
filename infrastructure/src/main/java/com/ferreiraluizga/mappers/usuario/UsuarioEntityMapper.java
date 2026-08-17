package com.ferreiraluizga.mappers.usuario;

import com.ferreiraluizga.entities.Usuario;
import com.ferreiraluizga.persistence.usuario.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class UsuarioEntityMapper {

    // entity -> domain
    public Usuario toDomain(UsuarioEntity entity) {
        return new Usuario(
                entity.getId(),
                entity.getNome(),
                entity.getEmail(),
                entity.getSenha(),
                entity.getRole()
        );
    }

    // domain -> entity
    public UsuarioEntity toEntity(Usuario usuario) {
        return new UsuarioEntity(
                usuario.id(),
                usuario.nome(),
                usuario.email(),
                usuario.senha(),
                usuario.role()
        );
    }

}
