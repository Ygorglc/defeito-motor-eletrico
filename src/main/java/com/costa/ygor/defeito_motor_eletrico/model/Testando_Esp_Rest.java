package com.costa.ygor.defeito_motor_eletrico.model;

import javax.persistence.*;

@Entity
@Table(name = "TESTANDO_ESP_REST")
@SequenceGenerator(name = "TESTANDO_ESP_REST_SEQ", sequenceName = "TESTANDO_ESP_REST_SEQ", allocationSize = 1)
public class Testando_Esp_Rest {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TESTANDO_ESP_REST_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    public Testando_Esp_Rest(String descricao) {
        this.descricao = descricao;
    }

    public Testando_Esp_Rest() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}
