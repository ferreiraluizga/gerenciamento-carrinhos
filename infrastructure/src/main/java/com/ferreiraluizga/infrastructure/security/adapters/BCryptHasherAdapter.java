package com.ferreiraluizga.infrastructure.security.adapters;

import com.ferreiraluizga.gateways.PasswordHasher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCryptHasherAdapter implements PasswordHasher {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public String hash(String senha) {
        return encoder.encode(senha);
    }

    @Override
    public Boolean verificar(String senha, String senhaCriptografada) {
        return encoder.matches(senha, senhaCriptografada);
    }
}
