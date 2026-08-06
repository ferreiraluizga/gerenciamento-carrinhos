package com.ferreiraluizga.infrastructure.persistence.ocorrencia;

import com.ferreiraluizga.enums.StatusOcorrencia;
import com.ferreiraluizga.infrastructure.persistence.dispositivo.DispositivoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "ocorrencias")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OcorrenciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dispositivo_id", nullable = false)
    private DispositivoEntity dispositivo;

    @Column(nullable = false)
    private LocalDateTime data;

    @Column(nullable = false)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_ocorrencia", nullable = false)
    private StatusOcorrencia statusOcorrencia;

    private String feedback;
    
    private LocalDateTime dataFeedback;

}
