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

    @Column(name = "EIXO_X")
    private double eixo_x;

    @Column(name = "EIXO_Y")
    private double eixo_y;

    @Column(name = "EIXO_Z")
    private double eixo_z;

    @ManyToOne
    @JoinColumn(name = "FK_TESTE")
    private Teste teste;

    public Aceleracao(double eixo_x, double eixo_y, double eixo_z, Teste teste) {
        this.eixo_x = eixo_x;
        this.eixo_y = eixo_y;
        this.eixo_z = eixo_z;
        this.teste = teste;
    }

    public Aceleracao() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getEixo_x() {
        return eixo_x;
    }

    public void setEixo_x(double eixo_x) {
        this.eixo_x = eixo_x;
    }

    public double getEixo_y() {
        return eixo_y;
    }

    public void setEixo_y(double eixo_y) {
        this.eixo_y = eixo_y;
    }

    public double getEixo_z() {
        return eixo_z;
    }

    public void setEixo_z(double eixo_z) {
        this.eixo_z = eixo_z;
    }

    public Teste getTeste() {
        return teste;
    }

    public void setTeste(Teste teste) {
        this.teste = teste;
    }
}
