package com.desafiosiad.DesafioSiad.domain;

import com.desafiosiad.DesafioSiad.model.Juridico;

public record RequestEndereco(
    String id,
    String cep,
    String cidade,
    String bairro,
    String rua,
    Number numero,
    Juridico juridico
    ) {

}
