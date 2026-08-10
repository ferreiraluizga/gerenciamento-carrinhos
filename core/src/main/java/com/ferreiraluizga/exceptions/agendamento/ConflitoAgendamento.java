package com.ferreiraluizga.exceptions.agendamento;

public class ConflitoAgendamento extends RuntimeException {
    public ConflitoAgendamento() {
        super("Houve um conflito no cadastro do agendamento");
    }
}
