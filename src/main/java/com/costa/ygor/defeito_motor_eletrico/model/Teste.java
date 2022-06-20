package com.costa.ygor.defeito_motor_eletrico.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@SequenceGenerator(name = "TESTE_SEQ", sequenceName = "TESTE_SEQ", allocationSize = 1)
public class Teste {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TESTE_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "DATA")
    private LocalDate data;

    public Teste(String descricao, LocalDate data) {
        this.descricao = descricao;
        this.data = data;
    }

    public Teste() {

    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
