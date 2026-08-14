package com.ferreiraluizga.infrastructure.config.beans;

import com.ferreiraluizga.gateways.PasswordHasher;
import com.ferreiraluizga.gateways.UsuarioGateway;
import com.ferreiraluizga.usecases.usuario.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioBeanConfiguration {

    @Bean
    public SalvarUsuarioUseCase salvarUsuarioUseCase(UsuarioGateway usuarioGateway, PasswordHasher passwordHasher) {
        return new SalvarUsuarioUseCaseImpl(usuarioGateway, passwordHasher);
    }

    @Bean
    public BuscarUsuarioPorEmailUseCase buscarUsuarioPorEmailUseCase(UsuarioGateway usuarioGateway) {
        return new BuscarUsuarioPorEmailUseCaseImpl(usuarioGateway);
    }

    @Bean
    public AutenticarUsuarioUseCase autenticarUsuarioUseCase(UsuarioGateway usuarioGateway, PasswordHasher passwordHasher) {
        return new AutenticarUsuarioUseCaseImpl(usuarioGateway, passwordHasher);
    }

}
