package com.costa.ygor.defeito_motor_eletrico.model;

import javax.persistence.*;

@Entity
@Table(name = "RESULTADO")
@SequenceGenerator(name = "RESULTADO_SEQ", sequenceName = "RESULTADO_SEQ", allocationSize = 1)
public class Resultado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESULTADO_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "POSSUI_DEFEITO")
    private boolean possuiDefeito;

    @Column(name = "DESCRICAO")
    private String descicao;

    @OneToOne
    @JoinColumn(name = "FK_TESTE")
    private Teste teste;

}
