package com.ferreiraluizga.infrastructure.presentation;

import com.ferreiraluizga.entities.Usuario;
import com.ferreiraluizga.infrastructure.dtos.request.LoginRequest;
import com.ferreiraluizga.infrastructure.dtos.request.UsuarioRequest;
import com.ferreiraluizga.infrastructure.dtos.response.LoginResponse;
import com.ferreiraluizga.infrastructure.dtos.response.UsuarioResponse;
import com.ferreiraluizga.infrastructure.mappers.usuario.UsuarioDtoMapper;
import com.ferreiraluizga.infrastructure.security.services.JwtService;
import com.ferreiraluizga.usecases.usuario.AutenticarUsuarioUseCase;
import com.ferreiraluizga.usecases.usuario.BuscarUsuarioPorEmailUseCase;
import com.ferreiraluizga.usecases.usuario.SalvarUsuarioUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final SalvarUsuarioUseCase salvarUsuarioUseCase;
    private final BuscarUsuarioPorEmailUseCase buscarUsuarioPorEmailUseCase;
    private final AutenticarUsuarioUseCase autenticarUsuarioUseCase;
    private final UsuarioDtoMapper usuarioDtoMapper;
    private final JwtService jwtService;

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioResponse> cadastrar(@Valid @RequestBody UsuarioRequest dto) {
        Usuario response = salvarUsuarioUseCase.execute(usuarioDtoMapper.toDomain(dto));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioDtoMapper.toDto(response));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest dto) {
        Usuario usuario = autenticarUsuarioUseCase.execute(dto.email(), dto.senha());
        String token = jwtService.generateToken(usuario);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new LoginResponse(token));
    }

}
