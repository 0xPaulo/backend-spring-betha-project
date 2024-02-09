package com.betha.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betha.backend.model.Cadastro;
import com.betha.backend.repository.CadastroRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/lista")
@AllArgsConstructor
public class ManutencaoController {

  private final CadastroRepository cadastroRepository;

  @GetMapping
  public List<Cadastro> list() {
    return cadastroRepository.findAll();
  }

}
