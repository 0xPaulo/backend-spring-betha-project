package com.betha.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

  @SuppressWarnings("null")
  @GetMapping("/{id}")
  public Optional<Cadastro> findById(@PathVariable Long id) {
    return this.cadastroRepository.findById(id);
  }

  @SuppressWarnings("null")
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public Cadastro create(@RequestBody Cadastro cadastro) {
    return cadastroRepository.save(cadastro);
  }

  @SuppressWarnings("null")
  @PostMapping("/{id}")
  public Cadastro editarItem(@PathVariable Long id, @RequestBody Cadastro cadastro) {
    return cadastroRepository.save(cadastro);
  }

}
