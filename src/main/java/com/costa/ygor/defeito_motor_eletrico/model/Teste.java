package com.costa.ygor.defeito_motor_eletrico.model;

import javax.persistence.*;

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

}
