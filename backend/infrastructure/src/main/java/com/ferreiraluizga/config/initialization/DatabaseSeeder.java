package com.ferreiraluizga.config.initialization;

import com.ferreiraluizga.entities.Usuario;
import com.ferreiraluizga.enums.UsuarioRole;
import com.ferreiraluizga.gateways.UsuarioGateway;
import com.ferreiraluizga.usecases.usuario.SalvarUsuarioUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DatabaseSeeder implements CommandLineRunner {

    private final SalvarUsuarioUseCase salvarUsuarioUseCase;
    private final UsuarioGateway usuarioGateway;

    @Override
    public void run(String... args) throws Exception {
        String emailAdmin = "admin@email.com";

        if (usuarioGateway.buscarUsuarioPorEmail(emailAdmin).isEmpty()) {
            Usuario adminPadrao = new Usuario(
                    null,
                    "Administrador Sistema",
                    emailAdmin,
                    "admin123",
                    UsuarioRole.ADMIN
            );

            try {
                salvarUsuarioUseCase.execute(adminPadrao);
                log.info("📢 [DatabaseSeeder] Usuário ADMIN padrão criado com sucesso: {} | Senha: admin123", emailAdmin);
            } catch (Exception e) {
                log.error("❌ [DatabaseSeeder] Erro ao criar usuário ADMIN padrão: {}", e.getMessage());
            }
        } else {
            log.info("📢 [DatabaseSeeder] Usuário ADMIN padrão já existente no banco de dados. Ignorando criação.");
        }
    }
}
