package com.ferreiraluizga.entities;

import com.ferreiraluizga.enums.StatusOcorrencia;

import java.time.LocalDateTime;

public record Ocorrencia(
        Long id,
        Dispositivo dispositivo,
        LocalDateTime data,
        String descricao,
        StatusOcorrencia statusOcorrencia,
        String feedback,
        LocalDateTime dataFeedback
) {

    public Ocorrencia definirOcorrenciaManutencao() {
        return new Ocorrencia(
                this.id(),
                this.dispositivo(),
                this.data(),
                this.descricao(),
                StatusOcorrencia.MANUTENCAO,
                this.feedback(),
                this.dataFeedback()
        );
    }

    public Ocorrencia fecharOcorrencia(String feedback) {
        return new Ocorrencia(
                this.id(),
                this.dispositivo(),
                this.data(),
                this.descricao(),
                StatusOcorrencia.FECHADA,
                feedback,
                LocalDateTime.now()
        );
    }

}
