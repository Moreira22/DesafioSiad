package com.desafiosiad.DesafioSiad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafiosiad.DesafioSiad.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, String> {

}
