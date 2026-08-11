package com.ferreiraluizga.infrastructure.persistence.turma;

import com.ferreiraluizga.enums.Turno;
import com.ferreiraluizga.infrastructure.persistence.agendamento.AgendamentoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "turmas")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TurmaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "turno", nullable = false)
    private Turno turno;

    @OneToMany(mappedBy = "turma")
    private List<AgendamentoEntity> agendamentos;

}
