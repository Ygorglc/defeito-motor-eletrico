package com.costa.ygor.defeito_motor_eletrico.controller.response;

public class MensagemResponse {
    private String mensagem;

    public MensagemResponse() {
    }

    public MensagemResponse(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

}
