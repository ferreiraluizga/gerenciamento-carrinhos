package com.ferreiraluizga.infrastructure.mappers.ocorrencia;

import com.ferreiraluizga.entities.Carrinho;
import com.ferreiraluizga.entities.Dispositivo;
import com.ferreiraluizga.entities.Ocorrencia;
import com.ferreiraluizga.infrastructure.persistence.carrinho.CarrinhoEntity;
import com.ferreiraluizga.infrastructure.persistence.dispositivo.DispositivoEntity;
import com.ferreiraluizga.infrastructure.persistence.ocorrencia.OcorrenciaEntity;
import org.springframework.stereotype.Component;

@Component
public class OcorrenciaEntityMapper {

    // entity -> domain
    public Ocorrencia toDomain(OcorrenciaEntity entity) {
        Dispositivo d = new Dispositivo(
                entity.getDispositivo().getId(),
                entity.getDispositivo().getSerial(),
                entity.getDispositivo().getNumDispositivo(),
                entity.getDispositivo().getModeloDispositivo(),
                entity.getDispositivo().getSistemaOperacional(),
                entity.getDispositivo().getAtivo(),
                entity.getDispositivo().getObservacao(),
                entity.getDispositivo().getManutencao(),
                new Carrinho(
                        entity.getDispositivo().getCarrinho().getId(),
                        entity.getDispositivo().getCarrinho().getDescricao(),
                        null,
                        null
                ),
                null
        );

        return new Ocorrencia(
                entity.getId(),
                d,
                entity.getData(),
                entity.getDescricao(),
                entity.getStatusOcorrencia(),
                entity.getFeedback(),
                entity.getDataFeedback()
        );
    }

    // domain -> entity
    public OcorrenciaEntity toEntity(Ocorrencia ocorrencia) {
        DispositivoEntity d = new DispositivoEntity(
                ocorrencia.dispositivo().id(),
                ocorrencia.dispositivo().serial(),
                ocorrencia.dispositivo().numDispositivo(),
                ocorrencia.dispositivo().modeloDispositivo(),
                ocorrencia.dispositivo().sistemaOperacional(),
                ocorrencia.dispositivo().ativo(),
                ocorrencia.dispositivo().observacao(),
                ocorrencia.dispositivo().manutencao(),
                new CarrinhoEntity(
                        ocorrencia.dispositivo().carrinho().id(),
                        ocorrencia.dispositivo().carrinho().descricao(),
                        null,
                        null
                ),
                null
        );

        return new OcorrenciaEntity(
                ocorrencia.id(),
                d,
                ocorrencia.data(),
                ocorrencia.descricao(),
                ocorrencia.statusOcorrencia(),
                ocorrencia.feedback(),
                ocorrencia.dataFeedback()
        );
    }

}
