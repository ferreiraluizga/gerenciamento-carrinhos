package com.ferreiraluizga.usecases.usuario;

import com.ferreiraluizga.entities.Usuario;

public interface AutenticarUsuarioUseCase {

    Usuario execute(String email, String senha);

}
