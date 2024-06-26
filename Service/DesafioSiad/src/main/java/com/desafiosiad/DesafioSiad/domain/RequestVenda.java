package com.desafiosiad.DesafioSiad.domain;

import com.desafiosiad.DesafioSiad.model.Fisica;
import com.desafiosiad.DesafioSiad.model.Produto;

public record RequestVenda(
        String id,
        Number total,
        Number quantidade,
        Fisica fisica,
        Produto produto) {

}
