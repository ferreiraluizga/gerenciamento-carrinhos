package com.ferreiraluizga.infrastructure.persistence.carrinho;

import com.ferreiraluizga.entities.Dispositivo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "carrinhos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarrinhoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    private String descricao;

}
