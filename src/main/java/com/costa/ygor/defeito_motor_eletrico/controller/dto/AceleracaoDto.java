package com.costa.ygor.defeito_motor_eletrico.controller.dto;

public class AceleracaoDto {
    double aceleracao;

    public AceleracaoDto(double aceleracao) {
        this.aceleracao = aceleracao;
    }

    public double getAceleracao() {
        return aceleracao;
    }

    public void setAceleracao(double aceleracao) {
        this.aceleracao = aceleracao;
    }
}
