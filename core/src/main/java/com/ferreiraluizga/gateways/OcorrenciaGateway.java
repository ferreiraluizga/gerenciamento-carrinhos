package com.ferreiraluizga.gateways;

import com.ferreiraluizga.entities.Ocorrencia;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface OcorrenciaGateway {

    Ocorrencia salvarOcorrencia(Ocorrencia ocorrencia);

    List<Ocorrencia> listarOcorrencias();

    Optional<Ocorrencia> buscarOcorrenciaPorId(Long id);

    Ocorrencia definirOcorrenciaManutencao(Ocorrencia ocorrencia);

    Ocorrencia fecharOcorrencia(Ocorrencia ocorrencia);

    void excluirOcorrencia(Long id);

}
