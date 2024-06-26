package com.desafiosiad.DesafioSiad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafiosiad.DesafioSiad.model.Juridico;

@Repository
public interface JuridicoRepository extends JpaRepository<Juridico, String>{

}
