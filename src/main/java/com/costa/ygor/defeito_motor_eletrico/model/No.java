package com.costa.ygor.defeito_motor_eletrico.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@SequenceGenerator(name = "NO_SEQ", sequenceName = "NO_SEQ", allocationSize = 1)
public class No {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NO_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "Nome")
    private String nome;

    @Column(name = "DATA_CADASTRO")
    private LocalDate dataCadastro;

    public No(String descricao, String nome, LocalDate dataCadastro) {
        this.descricao = descricao;
        this.nome = nome;
        this.dataCadastro = dataCadastro;
    }

    public No() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
