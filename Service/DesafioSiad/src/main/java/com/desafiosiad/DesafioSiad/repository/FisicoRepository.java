package com.desafiosiad.DesafioSiad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafiosiad.DesafioSiad.model.Fisica;

@Repository
public interface FisicoRepository extends JpaRepository<Fisica, String> {

}
