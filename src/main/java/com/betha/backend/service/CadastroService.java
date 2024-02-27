package com.betha.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betha.backend.model.Cadastro;
import com.betha.backend.repository.CadastroRepository;

@Service
public class CadastroService {

  private final CadastroRepository cadastroRepository;

  @Autowired
  public CadastroService(CadastroRepository cadastroRepository) {
    this.cadastroRepository = cadastroRepository;
  }

  public Cadastro editarItem(Long id, Cadastro cadastro) {
    Optional<Cadastro> cadastroExistente = cadastroRepository.findById(id);

    if (!cadastroExistente.isPresent()) {
      System.out.println("Cadastro nao encontrado pelo id: " + id);
    }

    Cadastro cadastroAtualizado = Cadastro.builder()
        .name(cadastro.getName())
        .item(cadastro.getItem())
        .defeito(cadastro.getDefeito())
        .dataEntrada(cadastro.getDataEntrada())
        .dataSaida(cadastro.getDataSaida())
        .valor(cadastro.getValor())
        .desc(cadastro.getDesc())
        .status(cadastro.getStatus())
        .email(cadastro.getEmail())
        .build();

    return cadastroAtualizado;
  }

}
