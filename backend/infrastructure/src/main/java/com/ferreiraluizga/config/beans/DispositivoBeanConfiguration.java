package com.ferreiraluizga.config.beans;

import com.ferreiraluizga.gateways.CarrinhoGateway;
import com.ferreiraluizga.gateways.DispositivoGateway;
import com.ferreiraluizga.usecases.dispositivo.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DispositivoBeanConfiguration {

    @Bean
    public SalvarDispositivoUseCase salvarDispositivoUseCase(DispositivoGateway dispositivoGateway, CarrinhoGateway carrinhoGateway) {
        return new SalvarDispositivoUseCaseImpl(dispositivoGateway, carrinhoGateway);
    }

    @Bean
    public ListarDispositivosUseCase listarDispositivosUseCase(DispositivoGateway dispositivoGateway) {
        return new ListarDispositivosUseCaseImpl(dispositivoGateway);
    }

    @Bean
    public BuscarDispositivoPorIdUseCase buscarDispositivoPorIdUseCase(DispositivoGateway dispositivoGateway) {
        return new BuscarDispositivoPorIdUseCaseImpl(dispositivoGateway);
    }

    @Bean
    public BuscarDispositivoPorSerialUseCase buscarDispositivoPorSerialUseCase(DispositivoGateway dispositivoGateway) {
        return new BuscarDispositivoPorSerialUseCaseImpl(dispositivoGateway);
    }

    @Bean
    public AtualizarDispositivoUseCase atualizarDispositivoUseCase(DispositivoGateway dispositivoGateway) {
        return new AtualizarDispositivoUseCaseImpl(dispositivoGateway);
    }

    @Bean
    public ExcluirDispositivoUseCase excluirDispositivoUseCase(DispositivoGateway dispositivoGateway) {
        return new ExcluirDispositivoUseCaseImpl(dispositivoGateway);
    }

}
