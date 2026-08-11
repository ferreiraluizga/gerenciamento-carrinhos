package com.ferreiraluizga.infrastructure.mappers.agendamento;

import com.ferreiraluizga.entities.Agendamento;
import com.ferreiraluizga.entities.Carrinho;
import com.ferreiraluizga.entities.Turma;
import com.ferreiraluizga.infrastructure.persistence.agendamento.AgendamentoEntity;
import com.ferreiraluizga.infrastructure.persistence.carrinho.CarrinhoEntity;
import com.ferreiraluizga.infrastructure.persistence.turma.TurmaEntity;
import org.springframework.stereotype.Component;

@Component
public class AgendamentoEntityMapper {

    // entity -> domain
    public Agendamento toDomain(AgendamentoEntity entity) {
        Carrinho c = new Carrinho(
                entity.getCarrinho().getId(),
                entity.getCarrinho().getDescricao(),
                null,
                null
        );

        Turma t = new Turma(
                entity.getTurma().getId(),
                entity.getTurma().getNome(),
                entity.getTurma().getTurno(),
                null
        );

        return new Agendamento(
                entity.getId(),
                entity.getProfessor(),
                c,
                entity.getTipoAgendamento(),
                t,
                entity.getAula(),
                entity.getData(),
                entity.getDiaDaSemana()
        );
    }

    // domain -> entity
    public AgendamentoEntity toEntity(Agendamento agendamento) {
        CarrinhoEntity c = new CarrinhoEntity(
                agendamento.carrinho().id(),
                agendamento.carrinho().descricao(),
                null,
                null
        );

        TurmaEntity t = new TurmaEntity(
                agendamento.turma().id(),
                agendamento.turma().nome(),
                agendamento.turma().turno(),
                null
        );

        return new AgendamentoEntity(
                agendamento.id(),
                agendamento.professor(),
                c,
                agendamento.tipoAgendamento(),
                t,
                agendamento.aula(),
                agendamento.data(),
                agendamento.diaDaSemana()
        );
    }

}
