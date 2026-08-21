package com.ferreiraluizga.exceptions.agendamento;

public class AgendamentoNaoEncontrado extends RuntimeException {
    public AgendamentoNaoEncontrado(Long id) {
        super("O agendamento " + id + " não foi encontrado");
    }
}
