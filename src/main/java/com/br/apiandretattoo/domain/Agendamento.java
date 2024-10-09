package com.br.apiandretattoo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "agendamentos")
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private String telefone;
    @Column(name = "tipo_agendamento")
    private String tipoAgendamento;
    private String descricao;
    @Column(name = "data_agendamento")
    private LocalDate dataAgendamento;

    public Agendamento(String id, String nome, String telefone, String tipoAgendamento, String descricao, LocalDate dataAgendamento) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.tipoAgendamento = tipoAgendamento;
        this.descricao = descricao;
        this.dataAgendamento = dataAgendamento;
    }

    public Agendamento() {
    }

    public Agendamento(RegistroAgendamento registroAgendamento) {
        this.nome = registroAgendamento.nome();
        this.telefone = registroAgendamento.telefone();
        this.tipoAgendamento = registroAgendamento.tipoAgendamento();
        this.descricao = registroAgendamento.descricao();
        this.dataAgendamento = registroAgendamento.dataAgendamento();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipoAgendamento() {
        return tipoAgendamento;
    }

    public void setTipoAgendamento(String tipoAgendamento) {
        this.tipoAgendamento = tipoAgendamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agendamento that = (Agendamento) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(telefone, that.telefone) && Objects.equals(tipoAgendamento, that.tipoAgendamento) && Objects.equals(descricao, that.descricao) && Objects.equals(dataAgendamento, that.dataAgendamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, telefone, tipoAgendamento, descricao, dataAgendamento);
    }
}
