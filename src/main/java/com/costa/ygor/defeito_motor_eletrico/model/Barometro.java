package com.costa.ygor.defeito_motor_eletrico.model;

import javax.persistence.*;

@Entity
@Table(name = "BAROMETRO")
@SequenceGenerator(name = "BAROMETRO_SEQ", sequenceName = "BAROMETRO_SEQ", allocationSize = 1)
public class Barometro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BAROMETRO_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "POSICAO")
    private Long posicao;

    @Column(name = "PRESSAO_ATMOSFERICA")
    private Double pressaoAtmosferica;

    @ManyToOne
    @JoinColumn(name = "FKPRESSAO_ATMOSFERICA_TESTE")
    private Teste teste;

    public Barometro(Long posicao, Double pressaoAtmosferica, Teste teste) {
        this.posicao = posicao;
        this.pressaoAtmosferica = pressaoAtmosferica;
        this.teste = teste;
    }

    public Barometro() {

    }

    public Long getId() {
        return id;
    }

    public Long getPosicao() {
        return posicao;
    }

    public void setPosicao(Long posicao) {
        this.posicao = posicao;
    }

    public Double getPressaoAtmosferica() {
        return pressaoAtmosferica;
    }

    public void setPressaoAtmosferica(Double pressaoAtmosferica) {
        this.pressaoAtmosferica = pressaoAtmosferica;
    }

    public Teste getTeste() {
        return teste;
    }

    public void setTeste(Teste teste) {
        this.teste = teste;
    }
}
