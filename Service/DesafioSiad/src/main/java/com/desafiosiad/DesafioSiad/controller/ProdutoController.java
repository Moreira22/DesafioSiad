package com.desafiosiad.DesafioSiad.controller;
import org.springframework.web.bind.annotation.RestController;

import com.desafiosiad.DesafioSiad.domain.RequestProduto;
import com.desafiosiad.DesafioSiad.model.Produto;
import com.desafiosiad.DesafioSiad.repository.ProdutoRepository;

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
@RequestMapping("/api/produto")
@AllArgsConstructor
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    @GetMapping("/All")
    public @ResponseBody List<Produto> findAll() {
        return produtoRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Produto>  findById(@PathVariable String id) {
        return produtoRepository.findById(id)
        .map(recordFound -> ResponseEntity.ok().body(recordFound))
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/register")
    public ResponseEntity<Produto> createCourse(@RequestBody @Valid RequestProduto data) {
        Produto newProduto = new Produto(data);
        produtoRepository.save(newProduto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateById(@PathVariable String id, @RequestBody RequestProduto data) {
        return produtoRepository.findById(id) // pesquisar pelo id
                .map(recordFound -> {
                    recordFound.setNome(data.nome());
                    recordFound.setValor(data.valor());
                    Produto updatd = produtoRepository.save(recordFound);
                    return ResponseEntity.ok().body(updatd);
                }) // se existe faz isso
                .orElse(ResponseEntity.notFound().build());// se não existe faz isso
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        produtoRepository.deleteById(id);
    }

}
