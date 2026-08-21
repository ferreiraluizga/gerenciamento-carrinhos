package com.ferreiraluizga.mappers.ocorrencia;

import com.ferreiraluizga.entities.Dispositivo;
import com.ferreiraluizga.entities.Ocorrencia;
import com.ferreiraluizga.enums.StatusOcorrencia;
import com.ferreiraluizga.dtos.request.OcorrenciaRequest;
import com.ferreiraluizga.dtos.response.DispositivoResponse;
import com.ferreiraluizga.dtos.response.OcorrenciaResponse;
import com.ferreiraluizga.mappers.dispositivo.DispositivoDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class OcorrenciaDtoMapper {

    private final DispositivoDtoMapper dispositivoDtoMapper;

    // dto -> domain (post)
    public Ocorrencia toDomain(OcorrenciaRequest dto) {
        Dispositivo d = new Dispositivo(
                dto.dispositivoId(),
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );

        return new Ocorrencia(
                null,
                d,
                LocalDateTime.now(),
                dto.descricao(),
                StatusOcorrencia.ABERTA,
                null,
                null
        );
    }

    // domain -> dto
    public OcorrenciaResponse toDto(Ocorrencia ocorrencia) {
        DispositivoResponse dispositivo = dispositivoDtoMapper.toDto(ocorrencia.dispositivo());
        return new OcorrenciaResponse(
                ocorrencia.id(),
                dispositivo,
                ocorrencia.data(),
                ocorrencia.descricao(),
                ocorrencia.statusOcorrencia(),
                ocorrencia.feedback(),
                ocorrencia.dataFeedback()
        );
    }

}
