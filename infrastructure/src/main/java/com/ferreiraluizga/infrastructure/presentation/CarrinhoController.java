package com.ferreiraluizga.infrastructure.presentation;

import com.ferreiraluizga.entities.Carrinho;
import com.ferreiraluizga.exceptions.CarrinhoNaoEncontrado;
import com.ferreiraluizga.infrastructure.dtos.request.CarrinhoRequest;
import com.ferreiraluizga.infrastructure.dtos.response.CarrinhoResponse;
import com.ferreiraluizga.infrastructure.mappers.carrinho.CarrinhoDtoMapper;
import com.ferreiraluizga.usecases.carrinho.BuscarCarrinhoPorIdUseCase;
import com.ferreiraluizga.usecases.carrinho.ListarCarrinhosUseCase;
import com.ferreiraluizga.usecases.carrinho.SalvarCarrinhoUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/carrinhos")
@RequiredArgsConstructor
public class CarrinhoController {

    private final CarrinhoDtoMapper carrinhoDtoMapper;
    private final SalvarCarrinhoUseCase salvarCarrinhoUseCase;
    private final ListarCarrinhosUseCase listarCarrinhosUseCase;
    private final BuscarCarrinhoPorIdUseCase buscarCarrinhoPorIdUseCase;

    @PostMapping
    public ResponseEntity<CarrinhoResponse> salvarCarrinho(@Valid @RequestBody CarrinhoRequest dto) {
        Carrinho response = salvarCarrinhoUseCase.execute(carrinhoDtoMapper.toDomain(dto));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(carrinhoDtoMapper.toDto(response));
    }

    @GetMapping
    public ResponseEntity<List<CarrinhoResponse>> listarCarrinhos() {
        List<Carrinho> response = listarCarrinhosUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK)
                .body(response.stream()
                        .map(carrinhoDtoMapper::toDto)
                        .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarrinhoResponse> buscarCarrinhoPorId(@PathVariable Long id) {
        Carrinho response = buscarCarrinhoPorIdUseCase.execute(id)
                .orElseThrow(() -> new CarrinhoNaoEncontrado(id));
        return ResponseEntity.status(HttpStatus.OK)
                .body(carrinhoDtoMapper.toDto(response));
    }

}
