package com.costa.ygor.defeito_motor_eletrico.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@SequenceGenerator(name = "TESTE_SEQ", sequenceName = "TESTE_SEQ", allocationSize = 1)
public class Teste {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TESTE_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "DATA")
    private LocalDate data;

    @OneToOne
    @JoinColumn(name = "FK_ID_NO")
    private No no;

    @OneToMany
    @JoinColumn(name = "FK_ACELERACAO")
    private List<Aceleracao> aceleracaos;

    @OneToMany
    @JoinColumn(name = "FK_VELOCIDADE")
    private List<Velocidade> velocidades;

    @OneToMany
    @JoinColumn(name = "FK_DESLOCAMENTO")
    private List<Deslocamento> deslocamentos;

    @OneToMany
    @JoinColumn(name = "FK_TEMPO")
    private List<Tempo> tempos;

    @OneToMany
    @JoinColumn(name = "FK_GIRO")
    private List<Giro> giros;

    @OneToMany
    @JoinColumn(name = "FK_BAROMETRO")
    private List<Barometro> barometros;

    @OneToMany
    @JoinColumn(name = "FK_MAGNETOMETRO")
    private List<Magnetometro> magnetometros;

    @OneToOne
    @JoinColumn(name = "FK_RESULTADO")
    private Resultado resultado;


    public Teste(String titulo, String descricao, LocalDate data, No no) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.no = no;
    }

    public Teste() {

    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public No getNo() {
        return no;
    }

    public void setNo(No no) {
        this.no = no;
    }

    public List<Aceleracao> getAceleracaos() {
        return aceleracaos;
    }

    public void setAceleracaos(List<Aceleracao> aceleracaos) {
        this.aceleracaos = aceleracaos;
    }

    public List<Velocidade> getVelocidades() {
        return velocidades;
    }

    public void setVelocidades(List<Velocidade> velocidades) {
        this.velocidades = velocidades;
    }

    public List<Deslocamento> getDeslocamentos() {
        return deslocamentos;
    }

    public void setDeslocamentos(List<Deslocamento> deslocamentos) {
        this.deslocamentos = deslocamentos;
    }

    public List<Tempo> getTempos() {
        return tempos;
    }

    public void setTempos(List<Tempo> tempos) {
        this.tempos = tempos;
    }

    public List<Giro> getGiros() {
        return giros;
    }

    public void setGiros(List<Giro> giros) {
        this.giros = giros;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }


}
