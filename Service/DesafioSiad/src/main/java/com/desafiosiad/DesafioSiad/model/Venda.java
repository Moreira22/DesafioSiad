package com.desafiosiad.DesafioSiad.model;

import com.desafiosiad.DesafioSiad.domain.RequestVenda;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(of = "id")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private Number total;

    @Column
    private Number quantidade;

    @ManyToOne
    @JoinColumn(name = "fisica_id")
    private Fisica fisica;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public Venda(Number total, Number quantidade, Fisica fisica, Produto produto) {
        this.fisica = fisica;
        this.produto = produto;
        this.quantidade = quantidade;
        this.total = total;
    }

    public Venda(RequestVenda data) {
        this.total = data.total();
        this.quantidade = data.quantidade();
        this.fisica = data.fisica();
        this.produto = data.produto();
    }

}
