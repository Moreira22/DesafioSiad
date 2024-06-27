package com.desafiosiad.DesafioSiad.model;

import java.util.List;

import com.desafiosiad.DesafioSiad.domain.RequestProduto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(of = "id")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private String nome;

    @Column
    private Number valor;

    @ManyToOne
    @JoinColumn(name = "juridico_id")
    private Juridico juridico;

    @OneToMany(mappedBy = "produto")
    private List<Venda> vendas;

    public Produto(String nome , Number valor, Juridico juridico, List<Venda> vendas ){
        this.nome = nome;
        this.valor = valor;
        this.vendas = vendas;
        this.juridico = juridico;
    }

    public Produto(RequestProduto data){
        this.nome = data.nome();
        this.valor = data.valor();
        this.vendas = data.vendas();
        this.juridico = data.juridico();
    }

}
