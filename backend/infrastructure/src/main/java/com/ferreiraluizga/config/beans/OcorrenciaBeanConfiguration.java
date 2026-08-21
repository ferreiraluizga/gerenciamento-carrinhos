package com.ferreiraluizga.config.beans;

import com.ferreiraluizga.gateways.DispositivoGateway;
import com.ferreiraluizga.gateways.OcorrenciaGateway;
import com.ferreiraluizga.usecases.ocorrencia.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class OcorrenciaBeanConfiguration {

    @Bean
    public SalvarOcorrenciaUseCase salvarOcorrenciaUseCase(OcorrenciaGateway ocorrenciaGateway, DispositivoGateway dispositivoGateway) {
        return new SalvarOcorrenciaUseCaseImpl(ocorrenciaGateway, dispositivoGateway);
    }

    @Bean
    public ListarOcorrenciasUseCase listarOcorrenciasUseCase(OcorrenciaGateway ocorrenciaGateway) {
        return new ListarOcorrenciasUseCaseImpl(ocorrenciaGateway);
    }

    @Bean
    public BuscarOcorrenciaPorIdUseCase buscarOcorrenciaPorIdUseCase(OcorrenciaGateway ocorrenciaGateway) {
        return new BuscarOcorrenciaPorIdUseCaseImpl(ocorrenciaGateway);
    }

    @Bean
    public DefinirOcorrenciaManutencaoUseCase definirOcorrenciaManutencaoUseCase(OcorrenciaGateway ocorrenciaGateway, DispositivoGateway dispositivoGateway) {
        return new DefinirOcorrenciaManutencaoUseCaseImpl(ocorrenciaGateway, dispositivoGateway);
    }

    @Bean
    public FecharOcorrenciaUseCase fecharOcorrenciaUseCase(OcorrenciaGateway ocorrenciaGateway, DispositivoGateway dispositivoGateway) {
        return new FecharOcorrenciaUseCaseImpl(ocorrenciaGateway, dispositivoGateway);
    }

    @Bean
    public ExcluirOcorrenciaUseCase excluirOcorrenciaUseCase(OcorrenciaGateway ocorrenciaGateway) {
        return new ExcluirOcorrenciaUseCaseImpl(ocorrenciaGateway);
    }

}
