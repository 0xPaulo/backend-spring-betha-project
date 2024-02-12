package com.betha.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betha.backend.model.Cadastro;
import com.betha.backend.repository.CadastroRepository;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/lista")
@AllArgsConstructor
public class ManutencaoController {

  private final CadastroRepository cadastroRepository;

  @GetMapping
  public List<Cadastro> list() {
    return cadastroRepository.findAll();
  }

  // @SuppressWarnings("null")
  @SuppressWarnings("null")
  @PostMapping
  public ResponseEntity<Cadastro> create(@RequestBody Cadastro cadastro) {
    System.out.println(cadastro);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(cadastroRepository.save(cadastro));

  }

}
