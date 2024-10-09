package com.br.apiandretattoo.repository;

import com.br.apiandretattoo.domain.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, String> {
}
