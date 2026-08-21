package com.ferreiraluizga.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @NotBlank @Email String email,
        @NotBlank @Size(min = 8, message = "A senha deve conter no mínimo 8 caracteres") String senha
) { }
