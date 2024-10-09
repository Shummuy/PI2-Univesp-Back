package com.br.apiandretattoo.domain;

import java.time.LocalDate;
import java.util.Date;

public record DetalhesAgendamento(String id, String nome, String telefone, String tipoAgendamento, LocalDate dataAgendamento) {
    public DetalhesAgendamento (Agendamento agendamento){
        this(agendamento.getId(), agendamento.getNome(), agendamento.getTelefone(), agendamento.getTipoAgendamento(), agendamento.getDataAgendamento());
    }
}
