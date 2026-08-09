package com.ferreiraluizga.infrastructure.presentation;

import com.ferreiraluizga.entities.Carrinho;
import com.ferreiraluizga.infrastructure.dtos.request.CarrinhoRequest;
import com.ferreiraluizga.infrastructure.dtos.response.CarrinhoResponse;
import com.ferreiraluizga.infrastructure.mappers.carrinho.CarrinhoDtoMapper;
import com.ferreiraluizga.usecases.carrinho.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/carrinhos")
@RequiredArgsConstructor
public class CarrinhoController {

    private final CarrinhoDtoMapper carrinhoDtoMapper;
    private final SalvarCarrinhoUseCase salvarCarrinhoUseCase;
    private final ListarCarrinhosUseCase listarCarrinhosUseCase;
    private final BuscarCarrinhoPorIdUseCase buscarCarrinhoPorIdUseCase;
    private final AtualizarCarrinhoUseCase atualizarCarrinhoUseCase;
    private final ExcluirCarrinhoUseCase excluirCarrinhoUseCase;

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
        Carrinho response = buscarCarrinhoPorIdUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(carrinhoDtoMapper.toDto(response));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarrinhoResponse> atualizarCarrinho(@PathVariable Long id, @Valid @RequestBody CarrinhoRequest dto) {
        Carrinho response = atualizarCarrinhoUseCase.execute(carrinhoDtoMapper.toDomain(id, dto));
        return ResponseEntity.status(HttpStatus.OK)
                .body(carrinhoDtoMapper.toDto(response));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCarrinho(@PathVariable Long id) {
        excluirCarrinhoUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }

}
