package com.costa.ygor.defeito_motor_eletrico.model;

import javax.persistence.*;

@Entity
@Table(name = "TEMPO")
@SequenceGenerator(name = "TEMPO_SEQ", sequenceName = "TEMPO_SEQ", allocationSize = 1)
public class Tempo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEMPO_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "VALOR_TEMPO")
    private double valorTempo;

    @ManyToOne
    @JoinColumn(name = "FKATEMPO_TESTE")
    private Teste teste;

}
