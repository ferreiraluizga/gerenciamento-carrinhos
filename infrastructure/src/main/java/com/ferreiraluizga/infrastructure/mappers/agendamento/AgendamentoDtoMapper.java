package com.ferreiraluizga.infrastructure.mappers.agendamento;

import com.ferreiraluizga.entities.Agendamento;
import com.ferreiraluizga.entities.Carrinho;
import com.ferreiraluizga.entities.Turma;
import com.ferreiraluizga.infrastructure.dtos.request.AgendamentoRequest;
import com.ferreiraluizga.infrastructure.dtos.response.AgendamentoResponse;
import org.springframework.stereotype.Component;

@Component
public class AgendamentoDtoMapper {

    // dto -> domain
    public Agendamento toDomain(AgendamentoRequest dto) {
        Carrinho c = new Carrinho(
                dto.carrinhoId(),
                null,
                null,
                null
        );

        Turma t = new Turma(
                dto.turmaId(),
                null,
                null,
                null
        );

        return new Agendamento(
                null,
                dto.professor(),
                c,
                dto.tipoAgendamento(),
                t,
                dto.aula(),
                dto.data(),
                dto.diaDaSemana()
        );
    }

    // domain -> dto
    public AgendamentoResponse toDto(Agendamento agendamento) {
        return new AgendamentoResponse(
                agendamento.id(),
                agendamento.professor(),
                agendamento.carrinho().id(),
                agendamento.carrinho().descricao(),
                agendamento.tipoAgendamento(),
                agendamento.turma().nome(),
                agendamento.aula(),
                agendamento.data(),
                agendamento.diaDaSemana()
        );
    }

}
