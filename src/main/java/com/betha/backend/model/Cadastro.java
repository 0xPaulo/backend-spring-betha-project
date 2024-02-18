package com.betha.backend.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Cadastros")
public class Cadastro {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @JsonProperty("_id")
  private Long id;

  @Column(name = "Nome_Cliente", length = 200, nullable = false)
  private String name;

  @Column(name = "Item", length = 200, nullable = false)
  private String item;

  @Column(name = "Defeito_item", nullable = false)
  private String defeito;

  @Column(name = "Data_Entrada")
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  private LocalDate dataEntrada = LocalDate.now();

  @Column(name = "Data_Saida")
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  private LocalDate dataSaida = LocalDate.now();

  @Column(name = "Valor")
  private int valor;

  @Enumerated(EnumType.STRING)
  private com.betha.backend.Enum.Status status;
}
