package com.desafiosiad.DesafioSiad.model;

import java.time.LocalDate;
import java.util.List;

import com.desafiosiad.DesafioSiad.domain.RequestJuridico;

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

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToMany(mappedBy = "juridico")
    private List<Produto> produtos;

     public Juridico(LocalDate dataNascimento, String nome, String cnpj, Endereco endereco, List<Produto> produtos) {
        super(dataNascimento, nome);
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.produtos = produtos;
     }
     public Juridico(RequestJuridico data){
      super(data.dataNascimento(), data.nome());
      this.cnpj = data.cnpj();
      this.endereco = data.endereco();
      this.produtos = data.produtos();
     }

}
