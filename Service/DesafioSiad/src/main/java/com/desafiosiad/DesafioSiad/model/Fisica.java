package com.desafiosiad.DesafioSiad.model;

import java.time.LocalDate;
import java.util.List;

import com.desafiosiad.DesafioSiad.domain.RequestFisico;

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
@DiscriminatorValue("fisico")
public class Fisica extends Pessoa {
    @Column
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @OneToMany(mappedBy = "fisica")
    private List<Venda> vendas;

    public Fisica(LocalDate dataNascimento, String nome, String cpf, Endereco endereco, List<Venda> vendas) {
        super(dataNascimento, nome);
        this.cpf = cpf;
        this.endereco = endereco;
        this.vendas = vendas;
     }

    public Fisica( RequestFisico data) {
        super(data.dataNascimento(),data.nome());
        this.cpf = data.cpf();
        this.endereco = data.endereco();
        this.vendas = data.vendas();
    }

}
