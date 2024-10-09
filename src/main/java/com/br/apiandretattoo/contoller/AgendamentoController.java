package com.br.apiandretattoo.contoller;

import com.br.apiandretattoo.domain.Agendamento;
import com.br.apiandretattoo.domain.DetalhesAgendamento;
import com.br.apiandretattoo.domain.RegistroAgendamento;
import com.br.apiandretattoo.repository.AgendamentoRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("agendamentos")
public class AgendamentoController {

    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoController(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity registrar(@RequestBody @Valid RegistroAgendamento registroAgendamento, UriComponentsBuilder uriBuilder) {
        var agendamento = new Agendamento(registroAgendamento);
        agendamento.setDataAgendamento(LocalDate.parse(agendamento.getDataAgendamento().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
        agendamentoRepository.save(agendamento);
        var uri = uriBuilder.path("/agendamentos/{id}").buildAndExpand(agendamento.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesAgendamento(agendamento));
    }
}
