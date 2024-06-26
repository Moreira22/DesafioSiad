package com.desafiosiad.DesafioSiad.controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.desafiosiad.DesafioSiad.domain.RequestVenda;
import com.desafiosiad.DesafioSiad.model.Venda;
import com.desafiosiad.DesafioSiad.repository.VendaRepository;

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
@RequestMapping("/api/venda")
@AllArgsConstructor
public class VendaController {
    private final VendaRepository vendaRepository;

    @GetMapping("/All")
    public @ResponseBody List<Venda> findAll() {
        return vendaRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Venda>  findById(@PathVariable String id) {
        return vendaRepository.findById(id)
        .map(recordFound -> ResponseEntity.ok().body(recordFound))
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/register")
    public ResponseEntity<Venda> createCourse(@RequestBody @Valid RequestVenda data) {
        Venda newVenda = new Venda(data);
        vendaRepository.save(newVenda);
        return ResponseEntity.status(HttpStatus.CREATED).body(newVenda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venda> updateById(@PathVariable String id, @RequestBody RequestVenda data) {
        return vendaRepository.findById(id) // pesquisar pelo id
                .map(recordFound -> {
                    recordFound.setQuantidade(data.quantidade());
                    recordFound.setTotal(data.total());
                    Venda updatd = vendaRepository.save(recordFound);
                    return ResponseEntity.ok().body(updatd);
                }) // se existe faz isso
                .orElse(ResponseEntity.notFound().build());// se não existe faz isso
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        vendaRepository.deleteById(id);
    }




}
