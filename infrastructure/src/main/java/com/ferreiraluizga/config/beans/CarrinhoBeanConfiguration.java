package com.ferreiraluizga.config.beans;

import com.ferreiraluizga.gateways.CarrinhoGateway;
import com.ferreiraluizga.usecases.carrinho.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarrinhoBeanConfiguration {

    @Bean
    public SalvarCarrinhoUseCase salvarCarrinhoUseCase(CarrinhoGateway carrinhoGateway) {
        return new SalvarCarrinhoUseCaseImpl(carrinhoGateway);
    }

    @Bean
    public ListarCarrinhosUseCase listarCarrinhosUseCase(CarrinhoGateway carrinhoGateway) {
        return new ListarCarrinhosUseCaseImpl(carrinhoGateway);
    }

    @Bean
    public BuscarCarrinhoPorIdUseCase buscarCarrinhoPorIdUseCase(CarrinhoGateway carrinhoGateway) {
        return new BuscarCarrinhoPorIdUseCaseImpl(carrinhoGateway);
    }

    @Bean
    public AtualizarCarrinhoUseCase atualizarCarrinhoUseCase(CarrinhoGateway carrinhoGateway) {
        return new AtualizarCarrinhoUseCaseImpl(carrinhoGateway);
    }

    @Bean
    public ExcluirCarrinhoUseCase excluirCarrinhoUseCase(CarrinhoGateway carrinhoGateway) {
        return new ExcluirCarrinhoUseCaseImpl(carrinhoGateway);
    }

}
