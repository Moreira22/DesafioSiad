package com.desafiosiad.DesafioSiad.domain;

import com.desafiosiad.DesafioSiad.model.Endereco;
import com.desafiosiad.DesafioSiad.model.Venda;

import java.time.LocalDate;

import java.util.List;

public record RequestFisico(
        String id,
        String nome,
        LocalDate dataNascimento,
        String cpf,
        Endereco endereco,
        List<Venda> vendas) {

}
