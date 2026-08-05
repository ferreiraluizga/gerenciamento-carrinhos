package com.ferreiraluizga.infrastructure.persistence.dispositivo;

import com.ferreiraluizga.enums.ModeloDispositivo;
import com.ferreiraluizga.enums.SistemaOperacional;
import com.ferreiraluizga.infrastructure.persistence.carrinho.CarrinhoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dispositivos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DispositivoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 20)
    private String serial;

    @Column(name = "num_dispositivo")
    private Integer numDispositivo;

    @Enumerated(EnumType.STRING)
    @Column(name = "modelo_dispositivo")
    private ModeloDispositivo modeloDispositivo;

    @Enumerated(EnumType.STRING)
    @Column(name = "sistema_operacional")
    private SistemaOperacional sistemaOperacional;

    @Column(nullable = false)
    private Boolean ativo;

    private String observacao;

    @Column(nullable = false)
    private Boolean manutencao;

    @ManyToOne
    @JoinColumn(name = "carrinho_id", nullable = false)
    private CarrinhoEntity carrinho;

}
