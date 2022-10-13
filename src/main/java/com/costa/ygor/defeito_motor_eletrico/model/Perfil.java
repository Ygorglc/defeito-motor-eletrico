package com.costa.ygor.defeito_motor_eletrico.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "PERFIL")
public class Perfil implements Serializable {
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "NOME")
    private String nome;

    public Perfil(String nome) {
        this.nome = nome;
    }

    public Perfil() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }
}
