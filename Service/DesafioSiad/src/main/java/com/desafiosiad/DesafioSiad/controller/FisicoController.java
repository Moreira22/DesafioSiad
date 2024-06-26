package com.desafiosiad.DesafioSiad.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.desafiosiad.DesafioSiad.domain.RequestFisico;
import com.desafiosiad.DesafioSiad.model.Fisica;
import com.desafiosiad.DesafioSiad.repository.FisicoRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/fisico")
@AllArgsConstructor
public class FisicoController {

    private final FisicoRepository fisicoRepository;

    @GetMapping("/All")
    public @ResponseBody List<Fisica> findAll() {
        return fisicoRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Fisica>  findById(@PathVariable String id) {
        return fisicoRepository.findById(id)
        .map(recordFound -> ResponseEntity.ok().body(recordFound))
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/register")
    public ResponseEntity<Fisica> createCourse(@RequestBody @Valid RequestFisico data) {
        Fisica newFisica = new Fisica(data);
        fisicoRepository.save(newFisica);
        return ResponseEntity.status(HttpStatus.CREATED).body(newFisica);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fisica> updateById(@PathVariable String id, @RequestBody RequestFisico fisico) {
        return fisicoRepository.findById(id) // pesquisar pelo id
                .map(recordFound -> {
                    recordFound.setCpf(fisico.cpf());
                    recordFound.setDataNascimento(fisico.dataNascimento());
                    recordFound.setNome(fisico.nome());
                    Fisica updatd = fisicoRepository.save(recordFound);
                    return ResponseEntity.ok().body(updatd);
                }) // se existe faz isso
                .orElse(ResponseEntity.notFound().build());// se não existe faz isso
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        fisicoRepository.deleteById(id);
    }
}
