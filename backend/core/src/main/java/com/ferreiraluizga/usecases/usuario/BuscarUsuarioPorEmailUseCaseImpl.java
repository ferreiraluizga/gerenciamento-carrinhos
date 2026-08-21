package com.ferreiraluizga.usecases.usuario;

import com.ferreiraluizga.entities.Usuario;
import com.ferreiraluizga.exceptions.usuario.UsuarioNaoEncontrado;
import com.ferreiraluizga.gateways.UsuarioGateway;

public class BuscarUsuarioPorEmailUseCaseImpl implements BuscarUsuarioPorEmailUseCase {

    private final UsuarioGateway usuarioGateway;

    public BuscarUsuarioPorEmailUseCaseImpl(UsuarioGateway usuarioGateway) {
        this.usuarioGateway = usuarioGateway;
    }

    @Override
    public Usuario execute(String email) {
        return usuarioGateway.buscarUsuarioPorEmail(email)
                .orElseThrow(() -> new UsuarioNaoEncontrado(email));
    }

}
