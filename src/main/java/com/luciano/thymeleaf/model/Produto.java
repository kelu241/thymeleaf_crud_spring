package com.luciano.thymeleaf.model;

import java.math.BigDecimal;
import java.util.Date;

public class Produto {

  private String nome;
  private BigDecimal valor;
  private Integer ano;
  private Date data_lancamento;

  public Produto(String nome, BigDecimal valor, Integer ano, Date data_lancamento) {
    this.nome = nome;
    this.valor = valor;
    this.ano = ano;
    this.data_lancamento = data_lancamento;
  }
}
