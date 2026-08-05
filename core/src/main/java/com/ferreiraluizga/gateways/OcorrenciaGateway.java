package com.ferreiraluizga.gateways;

import com.ferreiraluizga.entities.Ocorrencia;

import java.util.List;
import java.util.Optional;

public interface OcorrenciaGateway {

    Ocorrencia salvarOcorrencia(Ocorrencia ocorrencia);

    List<Ocorrencia> listarOcorrencias();

    Optional<Ocorrencia> buscarOcorrenciaPorId(Long id);

    Ocorrencia definirOcorrenciaManutencao(Long id);

    Ocorrencia fecharOcorrencia(Long id);

    Ocorrencia excluirOcorrencia(Long id);

}
