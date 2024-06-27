package com.desafiosiad.DesafioSiad.model;

import com.desafiosiad.DesafioSiad.domain.RequestEndereco;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(of = "id")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private String cep;

    @Column
    private String cidade;

    @Column
    private String bairro;

    @Column
    private String rua;

    @Column
    private Number numero;

    @OneToOne(mappedBy = "endereco")
    private Juridico juridico;

    public Endereco(String cep, String cidade, String bairro, String rua, Number numero) {
        this.cep = cep;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
    }
    public Endereco(RequestEndereco data){
        this.bairro = data.bairro();
        this.cep = data.cep();
        this.cidade = data.cidade();
        this.numero = data.numero();
        this.rua = data.rua();
        this.juridico = data.juridico();
    }
}
