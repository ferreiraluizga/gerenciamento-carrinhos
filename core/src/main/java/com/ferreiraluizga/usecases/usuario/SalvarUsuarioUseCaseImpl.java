package com.ferreiraluizga.usecases.usuario;

import com.ferreiraluizga.entities.Usuario;
import com.ferreiraluizga.enums.UsuarioRole;
import com.ferreiraluizga.exceptions.usuario.EmailExistente;
import com.ferreiraluizga.gateways.PasswordHasher;
import com.ferreiraluizga.gateways.UsuarioGateway;

public class SalvarUsuarioUseCaseImpl implements SalvarUsuarioUseCase{

    private final UsuarioGateway usuarioGateway;
    private final PasswordHasher passwordHasher;

    public SalvarUsuarioUseCaseImpl(UsuarioGateway usuarioGateway, PasswordHasher passwordHasher) {
        this.usuarioGateway = usuarioGateway;
        this.passwordHasher = passwordHasher;
    }

    @Override
    public Usuario execute(Usuario usuario) {
        usuarioGateway.buscarUsuarioPorEmail(usuario.email())
                .ifPresent(u -> {
                    throw new EmailExistente(usuario.email());
                });

        String senhaCriptografada = passwordHasher.hash(usuario.senha());

        UsuarioRole role = (usuario.role() != null) ? usuario.role() : UsuarioRole.COMUM;

        return usuarioGateway.salvarUsuario(new Usuario(
                null,
                usuario.nome(),
                usuario.email(),
                senhaCriptografada,
                role
        ));
    }

}
