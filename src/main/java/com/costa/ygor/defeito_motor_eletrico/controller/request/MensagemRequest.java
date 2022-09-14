package com.costa.ygor.defeito_motor_eletrico.controller.request;

public class MensagemRequest {
    private String mensagem;

    public MensagemRequest(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
