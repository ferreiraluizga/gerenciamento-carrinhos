package com.ferreiraluizga.infrastructure.persistence.agendamento;

import com.ferreiraluizga.enums.Aula;
import com.ferreiraluizga.enums.DiaDaSemana;
import com.ferreiraluizga.enums.TipoAgendamento;
import com.ferreiraluizga.infrastructure.persistence.carrinho.CarrinhoEntity;
import com.ferreiraluizga.infrastructure.persistence.turma.TurmaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "agendamentos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AgendamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String professor;

    @ManyToOne
    @JoinColumn(name = "carrinho_id", nullable = false)
    private CarrinhoEntity carrinho;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_agendamento", nullable = false)
    private TipoAgendamento tipoAgendamento;

    @ManyToOne
    @JoinColumn(name = "turma_id", nullable = false)
    private TurmaEntity turma;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Aula aula;

    private LocalDateTime data;

    @Enumerated(EnumType.STRING)
    @Column(name = "dia_da_semana")
    private DiaDaSemana diaDaSemana;

}
