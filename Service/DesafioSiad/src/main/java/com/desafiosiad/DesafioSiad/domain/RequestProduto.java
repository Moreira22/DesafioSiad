package com.desafiosiad.DesafioSiad.domain;

import java.util.List;

import com.desafiosiad.DesafioSiad.model.Juridico;
import com.desafiosiad.DesafioSiad.model.Venda;

public record RequestProduto(
        String id,
        String nome,
        Number valor,
        Juridico juridico,
        List<Venda> vendas) {

}
