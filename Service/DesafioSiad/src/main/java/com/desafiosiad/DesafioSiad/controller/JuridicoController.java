package com.desafiosiad.DesafioSiad.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.desafiosiad.DesafioSiad.domain.RequestJuridico;
import com.desafiosiad.DesafioSiad.model.Juridico;
import com.desafiosiad.DesafioSiad.repository.JuridicoRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/fisico")
@AllArgsConstructor
public class JuridicoController {
    private final JuridicoRepository juridicoRepository;

    @GetMapping("/All")
    public @ResponseBody List<Juridico> findAll() {
        return juridicoRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Juridico>  findById(@PathVariable String id) {
        return juridicoRepository.findById(id)
        .map(recordFound -> ResponseEntity.ok().body(recordFound))
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/register")
    public ResponseEntity<Juridico> createCourse(@RequestBody @Valid RequestJuridico data) {
        // System.out.println(course.getName());
        Juridico newjuritico = new Juridico(data);
        juridicoRepository.save(newjuritico);
        return ResponseEntity.status(HttpStatus.CREATED).body(newjuritico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Juridico> updateById(@PathVariable String id, @RequestBody RequestJuridico fisico) {
        return juridicoRepository.findById(id) // pesquisar pelo id
                .map(recordFound -> {
                    recordFound.setCnpj(fisico.cnpj());
                    recordFound.setDataNascimento(fisico.dataNascimento());
                    recordFound.setNome(fisico.nome());
                    Juridico updatd = juridicoRepository.save(recordFound);
                    return ResponseEntity.ok().body(updatd);
                }) // se existe faz isso
                .orElse(ResponseEntity.notFound().build());// se não existe faz isso
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        juridicoRepository.deleteById(id);
    }




}
