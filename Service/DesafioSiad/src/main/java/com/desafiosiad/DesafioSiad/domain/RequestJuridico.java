package com.desafiosiad.DesafioSiad.domain;
import java.time.LocalDate;
import java.util.List;

import com.desafiosiad.DesafioSiad.model.Endereco;
import com.desafiosiad.DesafioSiad.model.Produto;

public record RequestJuridico(
    String id,
    String nome,
    LocalDate dataNascimento,
    String cnpj,
    Endereco endereco,
    List<Produto> produtos) {

}
