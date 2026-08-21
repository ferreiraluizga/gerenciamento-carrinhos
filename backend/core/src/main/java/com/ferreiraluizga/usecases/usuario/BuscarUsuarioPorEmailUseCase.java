package com.ferreiraluizga.usecases.usuario;

import com.ferreiraluizga.entities.Usuario;

public interface BuscarUsuarioPorEmailUseCase {

    Usuario execute(String email);

}
