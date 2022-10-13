package com.costa.ygor.defeito_motor_eletrico.exception;

public class SenhaInvalidaException extends RuntimeException {
    public SenhaInvalidaException() {
        super("Senha inválida ou usuario invalido");
    }
}