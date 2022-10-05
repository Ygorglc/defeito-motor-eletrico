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

    @Column(name = "POSICAO")
    private Long posicao;

    @Column(name = "VALOR_TEMPO")
    private Double valorTempo;

    @ManyToOne
    @JoinColumn(name = "FKATEMPO_TESTE")
    private Teste teste;

    public Tempo(Double valorTempo, Teste teste) {
        this.posicao = posicao;
        this.valorTempo = valorTempo;
        this.teste = teste;
    }

    public Tempo() {

    }

    public Long getId() {
        return id;
    }

    public Double getValorTempo() {
        return valorTempo;
    }

    public void setValorTempo(Double valorTempo) {
        this.valorTempo = valorTempo;
    }

    public Teste getTeste() {
        return teste;
    }

    public void setTeste(Teste teste) {
        this.teste = teste;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPosicao() {
        return posicao;
    }

    public void setPosicao(Long posicao) {
        this.posicao = posicao;
    }
}
