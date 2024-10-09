package com.br.apiandretattoo.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;

public record RegistroAgendamento (
        @NotBlank
        String nome,
        @NotBlank
        String telefone,
        @NotBlank
        String tipoAgendamento,
        @NotBlank
        String descricao,
        @NotNull
        LocalDate dataAgendamento
){
}
