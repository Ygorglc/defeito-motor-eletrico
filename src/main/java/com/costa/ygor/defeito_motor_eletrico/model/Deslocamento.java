package com.costa.ygor.defeito_motor_eletrico.model;

import javax.persistence.*;

@Entity
@Table(name = "DESLOCAMENTO")
@SequenceGenerator(name = "DESLOCAMENTO_SEQ", sequenceName = "DELOCAMENTO_SEQ", allocationSize = 1)
public class Deslocamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DESLOCAMENTO_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "VALOR_DESLOCAMENTO")
    private String valorDeslocamento;

    @ManyToOne
    @JoinColumn(name = "FKDESLOCAMENTO_TESTE")
    private Teste teste;

}

