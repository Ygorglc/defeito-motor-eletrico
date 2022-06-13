package com.costa.ygor.defeito_motor_eletrico.model;

import javax.persistence.*;

@Entity
@Table(name = "Velocidade")
@SequenceGenerator(name = "VELOCIDADE_SEQ", sequenceName = "VELOCIDADE_SEQ", allocationSize = 1)
public class Velocidade {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VELOCIDADE_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "VALOR_VELOCIDADE")
    private double valorVelociade;

    @ManyToOne
    @JoinColumn(name = "FKAVELOCIDADE_TESTE")
    private Teste teste;

}
