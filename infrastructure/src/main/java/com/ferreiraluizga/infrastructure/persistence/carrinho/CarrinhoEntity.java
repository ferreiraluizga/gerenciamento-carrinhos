package com.ferreiraluizga.infrastructure.persistence.carrinho;

import com.ferreiraluizga.infrastructure.persistence.dispositivo.DispositivoEntity;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "carrinho")
    private List<DispositivoEntity> dispositivos;

}
