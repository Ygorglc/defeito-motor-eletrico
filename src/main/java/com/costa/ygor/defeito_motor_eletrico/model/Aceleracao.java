package com.costa.ygor.defeito_motor_eletrico.model;

import javax.persistence.*;

@Entity
@Table(name = "ACELERACAO")
@SequenceGenerator(name = "ACELERACAO_SEQ", sequenceName = "ACELERACAO_SEQ", allocationSize = 1)
public class Aceleracao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACELERACAO_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "VALOR_ACELERACAO")
    private double valorAcelecao;

    @ManyToOne
    @JoinColumn(name = "FKACELERACAO_TESTE")
    private Teste teste;

}
