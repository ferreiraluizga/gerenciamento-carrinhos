package com.ferreiraluizga.mappers.usuario;

import com.ferreiraluizga.entities.Usuario;
import com.ferreiraluizga.enums.UsuarioRole;
import com.ferreiraluizga.dtos.request.UsuarioRequest;
import com.ferreiraluizga.dtos.response.UsuarioResponse;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDtoMapper {

    // dto -> domain
    public Usuario toDomain(UsuarioRequest dto) {
        return new Usuario(
                null,
                dto.nome(),
                dto.email(),
                dto.senha(),
                UsuarioRole.COMUM
        );
    }

    // domain -> dto
    public UsuarioResponse toDto(Usuario usuario) {
        return new UsuarioResponse(
                usuario.id(),
                usuario.nome(),
                usuario.email(),
                "********",
                usuario.role()
        );
    }

}
