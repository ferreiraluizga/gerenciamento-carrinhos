package com.ferreiraluizga.gateways;

public interface PasswordHasher {

    String hash(String senha);

    Boolean verificar(String senha, String senhaCriptografada);

}
