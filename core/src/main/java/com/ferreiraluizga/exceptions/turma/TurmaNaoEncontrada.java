package com.ferreiraluizga.exceptions.turma;

public class TurmaNaoEncontrada extends RuntimeException {
    public TurmaNaoEncontrada(Long id) {
        super("A turma " + id + " não foi encontrada");
    }
}
