package com.ferreiraluizga.presentation;

import com.ferreiraluizga.entities.Usuario;
import com.ferreiraluizga.dtos.request.LoginRequest;
import com.ferreiraluizga.dtos.request.UsuarioRequest;
import com.ferreiraluizga.dtos.response.LoginResponse;
import com.ferreiraluizga.dtos.response.UsuarioResponse;
import com.ferreiraluizga.mappers.usuario.UsuarioDtoMapper;
import com.ferreiraluizga.security.services.JwtService;
import com.ferreiraluizga.usecases.usuario.AutenticarUsuarioUseCase;
import com.ferreiraluizga.usecases.usuario.BuscarUsuarioPorEmailUseCase;
import com.ferreiraluizga.usecases.usuario.SalvarUsuarioUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
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
