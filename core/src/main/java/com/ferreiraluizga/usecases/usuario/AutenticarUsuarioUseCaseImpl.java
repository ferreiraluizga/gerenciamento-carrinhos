package com.ferreiraluizga.usecases.usuario;

import com.ferreiraluizga.entities.Usuario;
import com.ferreiraluizga.exceptions.usuario.FalhaAutenticacao;
import com.ferreiraluizga.gateways.PasswordHasher;
import com.ferreiraluizga.gateways.UsuarioGateway;

public class AutenticarUsuarioUseCaseImpl implements AutenticarUsuarioUseCase{

    private final UsuarioGateway usuarioGateway;
    private final PasswordHasher passwordHasher;

    public AutenticarUsuarioUseCaseImpl(UsuarioGateway usuarioGateway, PasswordHasher passwordHasher) {
        this.usuarioGateway = usuarioGateway;
        this.passwordHasher = passwordHasher;
    }

    @Override
    public Usuario execute(String email, String senha) {
        Usuario usuario = usuarioGateway.buscarUsuarioPorEmail(email)
                .orElseThrow(FalhaAutenticacao::new);

        if (!passwordHasher.verificar(senha, usuario.senha())){
            throw new FalhaAutenticacao();
        }

        return usuario;
    }

}
