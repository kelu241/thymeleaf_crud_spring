package com.luciano.thymeleaf.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
  private String id;
  private String nome;
  private Double valor;
  private Integer ano;
  private LocalDate dataLancamento;

  public Produto(String nome, Double valor, Integer ano, LocalDate dataLancamento) {
    this.id = UUID.randomUUID().toString();
    this.nome = nome;
    this.valor = valor;
    this.ano = ano;
    this.dataLancamento = dataLancamento;

  }
}
