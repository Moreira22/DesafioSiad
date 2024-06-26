package com.desafiosiad.DesafioSiad.controller;
import org.springframework.web.bind.annotation.RestController;

import com.desafiosiad.DesafioSiad.domain.RequestEndereco;
import com.desafiosiad.DesafioSiad.model.Endereco;
import com.desafiosiad.DesafioSiad.repository.EnderecoRepository;

import java.util.List;



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
@RequestMapping("/api/endereco")
@AllArgsConstructor
public class EnderecoController {
    private final EnderecoRepository enderecoRepository;

    @GetMapping("/All")
    public @ResponseBody List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Endereco>  findById(@PathVariable String id) {
        return enderecoRepository.findById(id)
        .map(recordFound -> ResponseEntity.ok().body(recordFound))
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/register")
    public ResponseEntity<Endereco> createCourse(@RequestBody @Valid RequestEndereco data) {
        // System.out.println(course.getName());
        Endereco newEndereco = new Endereco(data);
        enderecoRepository.save(newEndereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEndereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> updateById(@PathVariable String id, @RequestBody RequestEndereco data) {
        return enderecoRepository.findById(id) // pesquisar pelo id
                .map(recordFound -> {
                    recordFound.setBairro(data.bairro());
                    recordFound.setCep(data.cep());
                    recordFound.setCidade(data.cidade());
                    recordFound.setNumero(data.numero());
                    recordFound.setRua(data.rua());
                    Endereco updatd = enderecoRepository.save(recordFound);
                    return ResponseEntity.ok().body(updatd);
                }) // se existe faz isso
                .orElse(ResponseEntity.notFound().build());// se não existe faz isso
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        enderecoRepository.deleteById(id);
    }



}
