package com.desafiosiad.DesafioSiad.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@DiscriminatorValue("juridico")
public class Juridico extends Pessoa {
    @Column
    private String cnpj;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Produto> produtos;

     public Juridico(LocalDate dataNascimento, String nome, String cnpj, Endereco endereco, List<Produto> produtos) {
        super(dataNascimento, nome);
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.produtos = produtos;
     }

}
