package com.ferreiraluizga.gateways;

import com.ferreiraluizga.entities.Usuario;

import java.util.Optional;

public interface UsuarioGateway {

    Usuario salvarUsuario(Usuario usuario);

    Optional<Usuario> buscarUsuarioPorEmail(String email);

}
