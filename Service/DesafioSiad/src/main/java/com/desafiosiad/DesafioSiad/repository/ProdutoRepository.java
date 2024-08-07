package com.desafiosiad.DesafioSiad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafiosiad.DesafioSiad.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, String> {

}
